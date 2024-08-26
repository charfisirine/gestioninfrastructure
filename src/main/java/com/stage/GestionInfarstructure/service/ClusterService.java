package com.stage.GestionInfarstructure.service;

import com.stage.GestionInfarstructure.domain.Cluster;
import com.stage.GestionInfarstructure.dto.ClusterDTO;
import com.stage.GestionInfarstructure.mapping.ClusterMapping;
import com.stage.GestionInfarstructure.repository.ClusterRepository;
import com.google.common.base.Preconditions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
public class ClusterService {

    private final ClusterRepository clusterRepository;

    public ClusterService(ClusterRepository clusterRepository) {
        this.clusterRepository = clusterRepository;
    }

    @Transactional(readOnly = true)
    public ClusterDTO findOne(Integer id) {
        Cluster cluster = clusterRepository.findById(id).orElse(null);
        return ClusterMapping.clusterToClusterDTO(cluster);
    }

    @Transactional(readOnly = true)
    public Collection<ClusterDTO> findAll() {
        Collection<Cluster> result = clusterRepository.findAll();
        return ClusterMapping.clustersToClusterDTOs(result);
    }

    public ClusterDTO add(ClusterDTO clusterDTO) {
        Preconditions.checkArgument(clusterDTO.getId() == null, "Cluster ID must be null for new entries");
        Cluster cluster = ClusterMapping.clusterDTOToCluster(clusterDTO);
        cluster = clusterRepository.save(cluster);
        return ClusterMapping.clusterToClusterDTO(cluster);
    }

    public ClusterDTO update(ClusterDTO clusterDTO) {
        Cluster clusterInBase = clusterRepository.findById(clusterDTO.getId()).orElse(null);
        Preconditions.checkArgument(clusterInBase != null, "Cluster has been deleted");

        Cluster cluster = ClusterMapping.clusterDTOToCluster(clusterDTO);
        cluster = clusterRepository.save(cluster);
        return ClusterMapping.clusterToClusterDTO(cluster);
    }

    public void deleteCluster(Integer id) {
        Preconditions.checkArgument(clusterRepository.existsById(id), "Cluster not found for deletion");
        clusterRepository.deleteById(id);
    }
}
