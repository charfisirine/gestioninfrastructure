package com.stage.GestionInfarstructure.mapping;

import com.stage.GestionInfarstructure.domain.ClusterApplication;
import com.stage.GestionInfarstructure.dto.ClusterApplicationDTO;
import com.stage.GestionInfarstructure.domain.Cluster;
import com.stage.GestionInfarstructure.domain.Application;
import com.stage.GestionInfarstructure.dto.ClusterDTO;
import com.stage.GestionInfarstructure.dto.ApplicationDTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ClusterApplicationMapping {

    // Convert ClusterApplicationDTO to ClusterApplication
    public static ClusterApplication clusterApplicationDTOToClusterApplication(ClusterApplicationDTO clusterApplicationDTO) {
        if (clusterApplicationDTO == null) {
            return null;
        }

        ClusterApplication clusterApplication = new ClusterApplication();
        clusterApplication.setId(clusterApplicationDTO.getId());
        clusterApplication.setStatus(clusterApplicationDTO.getStatus());

        if (clusterApplicationDTO.getApplication() != null) {
            Application application = ApplicationMapping.applicationDTOToApplication(clusterApplicationDTO.getApplication());
            clusterApplication.setApplication(application);
        }

        if (clusterApplicationDTO.getCluster() != null) {
            Cluster cluster = ClusterMapping.clusterDTOToCluster(clusterApplicationDTO.getCluster());
            clusterApplication.setCluster(cluster);
        }

        return clusterApplication;
    }

    // Convert ClusterApplication to ClusterApplicationDTO
    public static ClusterApplicationDTO clusterApplicationToClusterApplicationDTO(ClusterApplication clusterApplication) {
        if (clusterApplication == null) {
            return null;
        }

        ClusterApplicationDTO clusterApplicationDTO = new ClusterApplicationDTO();
        clusterApplicationDTO.setId(clusterApplication.getId());
        clusterApplicationDTO.setStatus(clusterApplication.getStatus());

        if (clusterApplication.getApplication() != null) {
            ApplicationDTO applicationDTO = ApplicationMapping.applicationToApplicationDTO(clusterApplication.getApplication());
            clusterApplicationDTO.setApplication(applicationDTO);
        }

        if (clusterApplication.getCluster() != null) {
            ClusterDTO clusterDTO = ClusterMapping.clusterToClusterDTO(clusterApplication.getCluster());
            clusterApplicationDTO.setCluster(clusterDTO);
        }

        return clusterApplicationDTO;
    }

    // Convert a collection of ClusterApplication entities to a collection of ClusterApplicationDTOs
    public static Collection<ClusterApplicationDTO> clusterApplicationsToClusterApplicationDTOs(Collection<ClusterApplication> clusterApplications) {
        List<ClusterApplicationDTO> clusterApplicationDTOs = new ArrayList<>();
        for (ClusterApplication clusterApplication : clusterApplications) {
            ClusterApplicationDTO clusterApplicationDTO = clusterApplicationToClusterApplicationDTO(clusterApplication);
            clusterApplicationDTOs.add(clusterApplicationDTO);
        }
        return clusterApplicationDTOs;
    }

    // Convert ClusterApplication to ClusterApplicationDTO with minimal fields
    public static ClusterApplicationDTO lazyClusterApplicationToClusterApplicationDTO(ClusterApplication clusterApplication) {
        if (clusterApplication == null) {
            return null;
        }

        ClusterApplicationDTO clusterApplicationDTO = new ClusterApplicationDTO();
        clusterApplicationDTO.setId(clusterApplication.getId());
        clusterApplicationDTO.setStatus(clusterApplication.getStatus());
        return clusterApplicationDTO;
    }
}
