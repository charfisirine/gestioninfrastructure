package com.stage.GestionInfarstructure.web.rest;

import com.stage.GestionInfarstructure.dto.SiteDTO;
import com.stage.GestionInfarstructure.service.SiteService;
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
@RequestMapping("/api/sites")
public class SiteRessource {

    private final SiteService siteService;
    private final String ENTITY_NAME = "Site";

    public SiteRessource(SiteService siteService) {
        this.siteService = siteService;
    }

    @GetMapping
    public Collection<SiteDTO> findAll() {
        return siteService.findAll();
    }

    @GetMapping("/{id}")
    public SiteDTO findOne(@PathVariable Integer id) {
        SiteDTO site = siteService.findOne(id);
        RestPreconditions.checkFound(site, ENTITY_NAME + " non trouvé");
        return site;
    }

    @PostMapping
    public ResponseEntity<SiteDTO> addSite(@RequestBody SiteDTO siteDTO, BindingResult bindingResults)
            throws URISyntaxException, MethodArgumentNotValidException {

        if (siteDTO.getId() != null) {
            bindingResults.addError(new FieldError(ENTITY_NAME, "id", "Le POST ne permet pas de créer une entité avec un ID"));
            throw new MethodArgumentNotValidException(null, bindingResults);
        }
        SiteDTO result = siteService.add(siteDTO);
        return ResponseEntity.created(new URI("/api/sites/" + result.getId())).body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SiteDTO> updateSite(@PathVariable Integer id, @RequestBody SiteDTO siteDTO, BindingResult bindingResults)
            throws MethodArgumentNotValidException {

        if (bindingResults.hasErrors()) {
            throw new MethodArgumentNotValidException(null, bindingResults);
        }

        if (!id.equals(siteDTO.getId())) {
            bindingResults.addError(new FieldError(ENTITY_NAME, "id", "L'ID dans le chemin et dans le corps doivent correspondre"));
            throw new MethodArgumentNotValidException(null, bindingResults);
        }

        SiteDTO result = siteService.update(siteDTO);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSite(@PathVariable Integer id) {
        siteService.deleteSite(id);
        return ResponseEntity.ok().build();
    }
}
