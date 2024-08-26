package com.stage.GestionInfarstructure.web.rest;

import com.stage.GestionInfarstructure.domain.ClusterApplication;
import com.stage.GestionInfarstructure.dto.ClusterApplicationDTO;
import com.stage.GestionInfarstructure.service.ClusterApplicationService;
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
@RequestMapping("/api/cluster-applications")
public class ClusterApplicationRessource {
    private final ClusterApplicationService clusterApplicationService;
    private final String ENTITY_NAME = "ClusterApplication";

    public ClusterApplicationRessource(ClusterApplicationService clusterApplicationService) {
        this.clusterApplicationService = clusterApplicationService;
    }

    @GetMapping
    public Collection<ClusterApplicationDTO> findAll() {
        return clusterApplicationService.findAll();
    }

    @GetMapping("/{id}")
    public ClusterApplication findOne(@PathVariable Integer id) {
        ClusterApplication clusterApplication = clusterApplicationService.findOne(id);

        RestPreconditions.checkFound(clusterApplication, ENTITY_NAME + " not found");

        return clusterApplication;
    }

    @PostMapping
    public ResponseEntity<ClusterApplicationDTO> addClusterApplication(@RequestBody ClusterApplicationDTO clusterApplicationDTO, BindingResult bindingResults)
            throws URISyntaxException, MethodArgumentNotValidException {

        if (clusterApplicationDTO.getId() != null) {
            bindingResults.addError(new FieldError(ENTITY_NAME, "clusterApplicationId", "Post does not allow a ClusterApplication with an ID"));
            throw new MethodArgumentNotValidException(null, bindingResults);
        }
        ClusterApplicationDTO result = clusterApplicationService.add(clusterApplicationDTO);
        return ResponseEntity.created(new URI("/api/cluster-applications/" + result.getId())).body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClusterApplicationDTO> updateClusterApplication(@PathVariable Integer id, @RequestBody ClusterApplicationDTO clusterApplicationDTO, BindingResult bindingResults)
            throws MethodArgumentNotValidException {

        if (bindingResults.hasErrors()) {
            throw new MethodArgumentNotValidException(null, bindingResults);
        }

        if (!id.equals(clusterApplicationDTO.getId())) {
            bindingResults.addError(new FieldError(ENTITY_NAME, "clusterApplicationId", "ID in path and body must match"));
            throw new MethodArgumentNotValidException(null, bindingResults);
        }

        ClusterApplicationDTO result = clusterApplicationService.update(clusterApplicationDTO);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClusterApplication(@PathVariable Integer id) {
        clusterApplicationService.deleteClusterApplication(id);
        return ResponseEntity.ok().build();
    }
}
