package com.stage.GestionInfarstructure.mapping;

import com.stage.GestionInfarstructure.domain.*;
import com.stage.GestionInfarstructure.dto.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ServeurMapping {

    public static Serveur serveurDTOTOServeur(ServeurDTO serveurDTO) {
        Serveur serveur = new Serveur();
        serveur.setServeurId(serveurDTO.getId());
        serveur.setHostName(serveurDTO.getHostName());
        serveur.setAddressIp(serveurDTO.getAdresseIp());
        serveur.setStatus(serveurDTO.getStatus());
        serveur.setSpecification(serveurDTO.getSpecification());

        if (serveurDTO.getCategoryServeur() != null) {
            CategoryServeur categoryServeur = CategoryServeurMapping.categoryServeurDTOTOCategoryServeur(serveurDTO.getCategoryServeur());
            serveur.setCategoryServeur(categoryServeur);
        }

        if (serveurDTO.getClusters() != null) {
            Cluster cluster = ClusterMapping.clusterDTOToCluster(serveurDTO.getClusters());
            serveur.setCluster(cluster);
        }

        if (serveurDTO.getApplications() != null) {
            Collection<Application> applications = new ArrayList<>();
            for (ApplicationDTO applicationDTO : serveurDTO.getApplications()) {
                Application application = ApplicationMapping.applicationDTOTOApplication(applicationDTO);
                applications.add(application);
            }
            serveur.setApplications(applications);
        }

        return serveur;
    }

    public static ServeurDTO serveurTOServeurDTO(Serveur serveur) {
        if (serveur != null) {
            ServeurDTO serveurDTO = new ServeurDTO();
            serveurDTO.setId(serveur.getServeurId());
            serveurDTO.setHostName(serveur.getHostName());
            serveurDTO.setAdresseIp(serveur.getAddressIp());
            serveurDTO.setStatus(serveur.getStatus());
            serveurDTO.setSpecification(serveur.getSpecification());

            if (serveur.getCategoryServeur() != null) {
                CategoryServeurDTO categoryServeurDTO = CategoryServeurMapping.categoryServeurTOCategoryServeurDTO(serveur.getCategoryServeur());
                serveurDTO.setCategoryServeur(categoryServeurDTO);
            }

            if (serveur.getCluster() != null) {
                ClusterDTO clusterDTO = ClusterMapping.clusterToClusterDTO(serveur.getCluster());
                serveurDTO.setClusters(clusterDTO);
            }

            if (serveur.getApplications() != null) {
                Collection<ApplicationDTO> applicationDTOs = new ArrayList<>();
                for (Application application : serveur.getApplications()) {
                    ApplicationDTO applicationDTO = ApplicationMapping.applicationTOApplicationDTO(application);
                    applicationDTOs.add(applicationDTO);
                }
                serveurDTO.setApplications(applicationDTOs);
            }

            return serveurDTO;
        } else {
            return null;
        }
    }

    public static ServeurDTO lazyServeurTOServeurDTO(Serveur serveur) {
        if (serveur != null) {
            ServeurDTO serveurDTO = new ServeurDTO();
            serveurDTO.setId(serveur.getServeurId());
            serveurDTO.setHostName(serveur.getHostName());
            serveurDTO.setAdresseIp(serveur.getAddressIp());
            serveurDTO.setStatus(serveur.getStatus());
            serveurDTO.setSpecification(serveur.getSpecification());
            return serveurDTO;
        } else {
            return null;
        }
    }

    public static Collection<ServeurDTO> serveursToServeurDTOs(Collection<Serveur> serveurs) {
        List<ServeurDTO> serveurDTOs = new ArrayList<>();
        for (Serveur serveur : serveurs) {
            ServeurDTO serveurDTO = lazyServeurTOServeurDTO(serveur);
            serveurDTOs.add(serveurDTO);
        }
        return serveurDTOs;
    }
}
