package com.stage.GestionInfarstructure.web.rest;

import com.stage.GestionInfarstructure.dto.CategoryServeurDTO;
import com.stage.GestionInfarstructure.service.CategoryServeurService;
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
@RequestMapping("/api/categoryServeurs")
public class CategoryServeurRessource {

    private final CategoryServeurService categoryServeurService;
    private final String ENTITY_NAME = "CategoryServeur";

    public CategoryServeurRessource(CategoryServeurService categoryServeurService) {
        this.categoryServeurService = categoryServeurService;
    }

    @GetMapping
    public Collection<CategoryServeurDTO> findAll() {
        return categoryServeurService.findAll();
    }

    @GetMapping("/{id}")
    public CategoryServeurDTO findOne(@PathVariable Integer id) {
        CategoryServeurDTO categoryServeur = categoryServeurService.findOne(id);
        RestPreconditions.checkFound(categoryServeur, ENTITY_NAME + " non trouvé");
        return categoryServeur;
    }

    @PostMapping
    public ResponseEntity<CategoryServeurDTO> addCategoryServeur(@RequestBody CategoryServeurDTO categoryServeurDTO, BindingResult bindingResults)
            throws URISyntaxException, MethodArgumentNotValidException {

        if (categoryServeurDTO.getId() != null) {
            bindingResults.addError(new FieldError(ENTITY_NAME, "id", "Le POST ne permet pas de créer une entité avec un ID"));
            throw new MethodArgumentNotValidException(null, bindingResults);
        }
        CategoryServeurDTO result = categoryServeurService.add(categoryServeurDTO);
        return ResponseEntity.created(new URI("/api/categoryServeurs/" + result.getId())).body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryServeurDTO> updateCategoryServeur(@PathVariable Integer id, @RequestBody CategoryServeurDTO categoryServeurDTO, BindingResult bindingResults)
            throws MethodArgumentNotValidException {

        if (bindingResults.hasErrors()) {
            throw new MethodArgumentNotValidException(null, bindingResults);
        }

        if (!id.equals(categoryServeurDTO.getId())) {
            bindingResults.addError(new FieldError(ENTITY_NAME, "id", "L'ID dans le chemin et dans le corps doivent correspondre"));
            throw new MethodArgumentNotValidException(null, bindingResults);
        }

        CategoryServeurDTO result = categoryServeurService.update(categoryServeurDTO);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoryServeur(@PathVariable Integer id) {
        categoryServeurService.deleteCategoryServeur(id);
        return ResponseEntity.ok().build();
    }
}
