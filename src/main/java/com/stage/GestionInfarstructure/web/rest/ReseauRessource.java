package com.stage.GestionInfarstructure.web.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;

import com.stage.GestionInfarstructure.util.RestPreconditions;
import com.stage.GestionInfarstructure.service.ReseauService;
import com.stage.GestionInfarstructure.domain.Reseau;
import com.stage.GestionInfarstructure.dto.ReseauDTO;

@RestController
@RequestMapping("/api/reseaux")
public class ReseauRessource {
     private final ReseauService reseauService;
     private static final String ENTITY_NAME = "Reseau";

     public ReseauRessource(ReseauService reseauService) {
        this.reseauService = reseauService;
    }
    @GetMapping
    public Collection<ReseauDTO> findAll() {
        return reseauService.findAll();
    }

    @GetMapping("/{id}")
    public Reseau findOne(@PathVariable Integer id) {
        Reseau reseau = reseauService.findOne(id);

        RestPreconditions.checkFound(reseau, ENTITY_NAME+"Reseau not found");

        return reseau;
    }

    @PostMapping
    public ResponseEntity<ReseauDTO> addReseau(@RequestBody ReseauDTO reseau, BindingResult bindingResults)
            throws URISyntaxException, MethodArgumentNotValidException {

        if (reseau.getIdReseau() != null) {
            bindingResults.addError(new FieldError(ENTITY_NAME, "idReseau", "Post does not allow an Reseau with an ID"));
            throw new MethodArgumentNotValidException(null, bindingResults);
        }
        ReseauDTO result = reseauService.add(reseau);
        return ResponseEntity.created(new URI("/api/reseaux/" + result.getIdReseau())).body(result);
    }





    @PutMapping("/{id}")
    public ResponseEntity<ReseauDTO> updateReseau(@PathVariable Integer id, @RequestBody ReseauDTO reseauDTO, BindingResult bindingResults)
            throws MethodArgumentNotValidException {

        if (bindingResults.hasErrors()) {
            throw new MethodArgumentNotValidException(null, bindingResults);
        }

        if (!id.equals(reseauDTO.getIdReseau())) {
            bindingResults.addError(new FieldError(ENTITY_NAME, "idReseau", "ID in path and body must match"));
            throw new MethodArgumentNotValidException(null, bindingResults);
        }

        ReseauDTO result = reseauService.update(reseauDTO);
        return ResponseEntity.ok(result);
    }






    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReseau(@PathVariable Integer id) {
        reseauService.deleteReseau(id);
        return ResponseEntity.ok().build();
    }



}
