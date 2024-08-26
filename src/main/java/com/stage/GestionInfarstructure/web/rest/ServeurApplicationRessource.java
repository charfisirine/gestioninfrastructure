package com.stage.GestionInfarstructure.web.rest;

import com.stage.GestionInfarstructure.domain.ServeurApplication;
import com.stage.GestionInfarstructure.dto.ServeurApplicationDTO;
import com.stage.GestionInfarstructure.service.ServeurApplicationService;
import com.stage.GestionInfarstructure.util.RestPreconditions;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;

@RestController
@RequestMapping("/api/serveur-applications")
public class ServeurApplicationRessource {
    private final ServeurApplicationService serveurApplicationService;
    private final String ENTITY_NAME = "ServeurApplication";

    public ServeurApplicationRessource(ServeurApplicationService serveurApplicationService) {
        this.serveurApplicationService = serveurApplicationService;
    }

    @GetMapping
    public Collection<ServeurApplicationDTO> findAll() {
        return serveurApplicationService.findAll();
    }

    @GetMapping("/{id}")
    public ServeurApplication findOne(@PathVariable Integer id) {
        ServeurApplication serveurApplication = serveurApplicationService.findOne(id);

        RestPreconditions.checkFound(serveurApplication, ENTITY_NAME + " not found");

        return serveurApplication;
    }

    @PostMapping
    public ResponseEntity<ServeurApplicationDTO> addServeurApplication(@RequestBody ServeurApplicationDTO serveurApplicationDTO, BindingResult bindingResults)
            throws URISyntaxException, MethodArgumentNotValidException {

        if (serveurApplicationDTO.getId() != null) {
            bindingResults.addError(new FieldError(ENTITY_NAME, "serveurApplicationId", "Post does not allow a ServeurApplication with an ID"));
            throw new MethodArgumentNotValidException(null, bindingResults);
        }
        ServeurApplicationDTO result = serveurApplicationService.add(serveurApplicationDTO);
        return ResponseEntity.created(new URI("/api/serveur-applications/" + result.getId())).body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServeurApplicationDTO> updateServeurApplication(@PathVariable Integer id, @RequestBody ServeurApplicationDTO serveurApplicationDTO, BindingResult bindingResults)
            throws MethodArgumentNotValidException {

        if (bindingResults.hasErrors()) {
            throw new MethodArgumentNotValidException(null, bindingResults);
        }

        if (!id.equals(serveurApplicationDTO.getId())) {
            bindingResults.addError(new FieldError(ENTITY_NAME, "serveurApplicationId", "ID in path and body must match"));
            throw new MethodArgumentNotValidException(null, bindingResults);
        }

        ServeurApplicationDTO result = serveurApplicationService.update(serveurApplicationDTO);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServeurApplication(@PathVariable Integer id) {
        serveurApplicationService.deleteServeurApplication(id);
        return ResponseEntity.ok().build();
    }
}
