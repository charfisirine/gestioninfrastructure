package com.stage.GestionInfarstructure.web.rest;

import com.stage.GestionInfarstructure.domain.Serveur;
import com.stage.GestionInfarstructure.dto.ServeurDTO;
import com.stage.GestionInfarstructure.service.ServeurService;
import com.stage.GestionInfarstructure.util.RestPreconditions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;

@RestController
@RequestMapping("/api/serveurs")
public class ServeurRessource {

    private final ServeurService serveurService;
    private static final String ENTITY_NAME = "Serveur";

    public ServeurRessource(ServeurService serveurService) {
        this.serveurService = serveurService;
    }

    @GetMapping("/{id}")
    public Serveur findOne(@PathVariable Integer id) {
        Serveur serveur= serveurService.findOne(id);

        RestPreconditions.checkFound(serveur, ENTITY_NAME + " not found");

        return serveur;
    }

    @GetMapping
    public Collection<ServeurDTO> findAll() {
        return serveurService.findAll();

    }

    @PostMapping
    public ResponseEntity<ServeurDTO> addServeur(@RequestBody ServeurDTO serveurDTO, BindingResult bindingResults)
            throws URISyntaxException, MethodArgumentNotValidException {

        if (serveurDTO.getServeurId() != null) {
            bindingResults.addError(new FieldError(ENTITY_NAME, "serveurId", "Post does not allow a Serveur with an ID"));
            throw new MethodArgumentNotValidException(null, bindingResults);
        }

        ServeurDTO result = serveurService.add(serveurDTO);
        return ResponseEntity.created(new URI("/api/serveurs/" + result.getServeurId())).body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServeurDTO> updateServeur(@PathVariable Integer id, @RequestBody ServeurDTO serveurDTO, BindingResult bindingResults)
            throws MethodArgumentNotValidException {

        if (bindingResults.hasErrors()) {
            throw new MethodArgumentNotValidException(null, bindingResults);
        }

        if (!id.equals(serveurDTO.getServeurId())) {
            bindingResults.addError(new FieldError(ENTITY_NAME, "serveurId", "ID in path and body must match"));
            throw new MethodArgumentNotValidException(null, bindingResults);
        }

        ServeurDTO updatedServeur = serveurService.update(serveurDTO);
        return ResponseEntity.ok(updatedServeur);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServeur(@PathVariable Integer id) {
        serveurService.deleteServeur(id);
        return ResponseEntity.noContent().build();
    }
}
