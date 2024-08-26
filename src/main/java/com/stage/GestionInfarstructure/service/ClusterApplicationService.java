package com.stage.GestionInfarstructure.service;

import com.google.common.base.Preconditions;
import com.stage.GestionInfarstructure.domain.ClusterApplication;
import com.stage.GestionInfarstructure.dto.ClusterApplicationDTO;
import com.stage.GestionInfarstructure.mapping.ClusterApplicationMapping;
import com.stage.GestionInfarstructure.repository.ClusterApplicationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service // Annoter cette classe pour en faire un bean Spring de type service
public class ClusterApplicationService {

    private final ClusterApplicationRepository clusterApplicationRepository;

    public ClusterApplicationService(ClusterApplicationRepository clusterApplicationRepository) {
        this.clusterApplicationRepository = clusterApplicationRepository;
    }

    @Transactional(readOnly = true)
    public ClusterApplication findOne(Integer id) {
        return clusterApplicationRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public Collection<ClusterApplicationDTO> findAll() {
        Collection<ClusterApplication> result = clusterApplicationRepository.findAll();
        return ClusterApplicationMapping.clusterApplicationsToClusterApplicationDTOs(result);
    }

    public ClusterApplicationDTO add(ClusterApplicationDTO clusterApplicationDTO) {
        Preconditions.checkArgument(clusterApplicationDTO.getApplication() != null, "L'application ne peut pas être nulle");
        ClusterApplication clusterApplication = ClusterApplicationMapping.clusterApplicationDTOToClusterApplication(clusterApplicationDTO);
        clusterApplication = clusterApplicationRepository.save(clusterApplication);
        return ClusterApplicationMapping.clusterApplicationToClusterApplicationDTO(clusterApplication);
    }

    public ClusterApplicationDTO update(ClusterApplicationDTO clusterApplicationDTO) {
        ClusterApplication clusterApplicationInBase = clusterApplicationRepository.findById(clusterApplicationDTO.getId()).orElse(null);
        Preconditions.checkArgument(clusterApplicationInBase != null, "ClusterApplication has been deleted");

        ClusterApplication clusterApplication = ClusterApplicationMapping.clusterApplicationDTOToClusterApplication(clusterApplicationDTO);
        clusterApplication = clusterApplicationRepository.save(clusterApplication);
        return ClusterApplicationMapping.clusterApplicationToClusterApplicationDTO(clusterApplication);
    }

    public void deleteClusterApplication(Integer id) {
        clusterApplicationRepository.deleteById(id);
    }
}
