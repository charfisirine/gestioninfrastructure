package com.stage.GestionInfarstructure.web.rest;

import com.stage.GestionInfarstructure.domain.Application;
import com.stage.GestionInfarstructure.dto.ApplicationDTO;
import com.stage.GestionInfarstructure.service.ApplicationService;
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


@RestController
@RequestMapping("/api/applications")
public class ApplicationRessource {
    private final ApplicationService applicationService;
    private  final String ENTITY_NAME = "Application";

    public ApplicationRessource(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }
    @GetMapping
    public Collection<ApplicationDTO> findAll() {

        return applicationService.findAll();
    }

    @GetMapping("/{id}")
    public Application findOne(@PathVariable Integer id) {
        Application application = applicationService.findOne(id);

        RestPreconditions.checkFound(application, ENTITY_NAME+"Reseau not found");

        return application;
    }

    @PostMapping
    public ResponseEntity<ApplicationDTO> addApplication(@RequestBody ApplicationDTO application, BindingResult bindingResults)
            throws URISyntaxException, MethodArgumentNotValidException {

        if (application.getApplicationId() != null) {
            bindingResults.addError(new FieldError(ENTITY_NAME, "idReseau", "Post does not allow an application with an ID"));
            throw new MethodArgumentNotValidException(null, bindingResults);
        }
        ApplicationDTO result = applicationService.add(application);
        return ResponseEntity.created(new URI("/api/applications/" + result.getApplicationId())).body(result);
    }





    @PutMapping("/{id}")
    public ResponseEntity<ApplicationDTO> updateApplication(@PathVariable Integer id, @RequestBody ApplicationDTO applicationDTO, BindingResult bindingResults)
            throws MethodArgumentNotValidException {

        if (bindingResults.hasErrors()) {
            throw new MethodArgumentNotValidException(null, bindingResults);
        }

        if (!id.equals(applicationDTO.getApplicationId())) {
            bindingResults.addError(new FieldError(ENTITY_NAME, "idReseau", "ID in path and body must match"));
            throw new MethodArgumentNotValidException(null, bindingResults);
        }

        ApplicationDTO result = applicationService.update(applicationDTO);
        return ResponseEntity.ok(result);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApplication(@PathVariable Integer id) {
        applicationService.deleteApplication(id);
        return ResponseEntity.ok().build();
    }



}
