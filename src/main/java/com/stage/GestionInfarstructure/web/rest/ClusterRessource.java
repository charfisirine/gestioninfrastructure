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
import com.stage.GestionInfarstructure.service.ClusterService;
import com.stage.GestionInfarstructure.dto.ClusterDTO;

@RestController
@RequestMapping("/api/clusters")
public class ClusterRessource {
    private final ClusterService clusterService;
    private static final String ENTITY_NAME = "Cluster";

    public ClusterRessource(ClusterService clusterService) {
        this.clusterService = clusterService;
    }

    @GetMapping
    public Collection<ClusterDTO> findAll() {
        return clusterService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClusterDTO> findOne(@PathVariable Integer id) {
        ClusterDTO clusterDTO = clusterService.findOne(id);
        RestPreconditions.checkFound(clusterDTO, ENTITY_NAME + " not found");
        return ResponseEntity.ok(clusterDTO);
    }

    @PostMapping
    public ResponseEntity<ClusterDTO> addCluster(@RequestBody ClusterDTO clusterDTO, BindingResult bindingResults)
            throws URISyntaxException, MethodArgumentNotValidException {

        if (clusterDTO.getId() != null) {
            bindingResults.addError(new FieldError(ENTITY_NAME, "id", "Post does not allow a Cluster with an ID"));
            throw new MethodArgumentNotValidException(null, bindingResults);
        }
        ClusterDTO result = clusterService.add(clusterDTO);
        return ResponseEntity.created(new URI("/api/clusters/" + result.getId())).body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClusterDTO> updateCluster(@PathVariable Integer id, @RequestBody ClusterDTO clusterDTO, BindingResult bindingResults)
            throws MethodArgumentNotValidException {

        if (bindingResults.hasErrors()) {
            throw new MethodArgumentNotValidException(null, bindingResults);
        }

        if (!id.equals(clusterDTO.getId())) {
            bindingResults.addError(new FieldError(ENTITY_NAME, "id", "ID in path and body must match"));
            throw new MethodArgumentNotValidException(null, bindingResults);
        }

        ClusterDTO result = clusterService.update(clusterDTO);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCluster(@PathVariable Integer id) {
        clusterService.deleteCluster(id);
        return ResponseEntity.ok().build();
    }
}
