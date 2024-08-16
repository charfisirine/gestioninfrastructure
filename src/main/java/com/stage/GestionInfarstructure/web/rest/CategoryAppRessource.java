package com.stage.GestionInfarstructure.web.rest;

import com.stage.GestionInfarstructure.dto.CategoryAppDTO;
import com.stage.GestionInfarstructure.service.CategoryAppService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;

import com.stage.GestionInfarstructure.util.RestPreconditions;

@RestController
@RequestMapping("/api/categoryApps")
public class CategoryAppRessource {

    private final CategoryAppService categoryAppService;
    private final String ENTITY_NAME = "CategoryApp";

    public CategoryAppRessource(CategoryAppService categoryAppService) {
        this.categoryAppService = categoryAppService;
    }

    @GetMapping
    public Collection<CategoryAppDTO> findAll() {
        return categoryAppService.findAll();
    }

    @GetMapping("/{id}")
    public CategoryAppDTO findOne(@PathVariable Integer id) {
        CategoryAppDTO categoryApp = categoryAppService.findOne(id);
        RestPreconditions.checkFound(categoryApp, ENTITY_NAME + " non trouvé");
        return categoryApp;
    }

    @PostMapping
    public ResponseEntity<CategoryAppDTO> addCategoryApp(@RequestBody CategoryAppDTO categoryAppDTO, BindingResult bindingResults)
            throws URISyntaxException, MethodArgumentNotValidException {

        if (categoryAppDTO.getId() != null) {
            bindingResults.addError(new FieldError(ENTITY_NAME, "id", "Le POST ne permet pas de créer une entité avec un ID"));
            throw new MethodArgumentNotValidException(null, bindingResults);
        }
        CategoryAppDTO result = categoryAppService.add(categoryAppDTO);
        return ResponseEntity.created(new URI("/api/categoryApps/" + result.getId())).body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryAppDTO> updateCategoryApp(@PathVariable Integer id, @RequestBody CategoryAppDTO categoryAppDTO, BindingResult bindingResults)
            throws MethodArgumentNotValidException {

        if (bindingResults.hasErrors()) {
            throw new MethodArgumentNotValidException(null, bindingResults);
        }

        if (!id.equals(categoryAppDTO.getId())) {
            bindingResults.addError(new FieldError(ENTITY_NAME, "id", "L'ID dans le chemin et dans le corps doivent correspondre"));
            throw new MethodArgumentNotValidException(null, bindingResults);
        }

        CategoryAppDTO result = categoryAppService.update(categoryAppDTO);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoryApp(@PathVariable Integer id) {
        categoryAppService.deleteCategoryApp(id);
        return ResponseEntity.ok().build();
    }
}
