package com.stage.GestionInfarstructure.rest;


import com.stage.GestionInfarstructure.dto.SousReseauDTO;
import com.stage.GestionInfarstructure.service.SousReseauService;
import com.stage.GestionInfarstructure.util.RestPreconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;

@RestController
@RequestMapping("/api/sousreseaus")
public class SousReseauRessource {

    @Autowired
    private SousReseauService sousReseauService;

    private static final String ENTITY_NAME = "SousReseau";

    @GetMapping
    public Collection<SousReseauDTO> findAll() {
        return sousReseauService.findAll();
    }

    @GetMapping("/{id}")
    public SousReseauDTO findOne(@PathVariable Integer id) {
        SousReseauDTO sousReseau = sousReseauService.findOne(id);
        RestPreconditions.checkFound(sousReseau, ENTITY_NAME + " not found");
        return sousReseau;
    }

    @PostMapping
    public ResponseEntity<SousReseauDTO> addSousReseau(@RequestBody SousReseauDTO sousReseau, BindingResult bindingResults) throws URISyntaxException, MethodArgumentNotValidException {
        if (bindingResults.hasErrors()) {
            throw new MethodArgumentNotValidException(null, bindingResults);
        }
        if (sousReseau.getIdSousReseau() != null) {
            bindingResults.addError(new FieldError(ENTITY_NAME, "idSousReseau", "Post does not allow a Sous Reseau with an ID"));
            throw new MethodArgumentNotValidException(null, bindingResults);
        }

        SousReseauDTO result = sousReseauService.add(sousReseau);
        return ResponseEntity.created(new URI("/api/sousReseaus/" + result.getIdSousReseau())).body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SousReseauDTO> updateSousReseau(@PathVariable Integer id, @RequestBody SousReseauDTO sousReseauDTO, BindingResult bindingResults)
            throws MethodArgumentNotValidException {

        if (bindingResults.hasErrors()) {
            throw new MethodArgumentNotValidException(null, bindingResults);
        }

        if (sousReseauDTO.getIdSousReseau() == null) {
            bindingResults.addError(new FieldError(ENTITY_NAME, "idSousReseau", "Put does not allow a Sous Reseau without an ID"));
            throw new MethodArgumentNotValidException(null, bindingResults);
        }

        SousReseauDTO result = sousReseauService.update(sousReseauDTO);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSousReseau(@PathVariable Integer id) {
        sousReseauService.deleteSousReseau(id);
        return ResponseEntity.ok().build();
    }




    }



