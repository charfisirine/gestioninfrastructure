package com.stage.GestionInfarstructure.mapping;

import com.stage.GestionInfarstructure.domain.*;
import com.stage.GestionInfarstructure.dto.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ServeurMapping {

    // Convert ServeurDTO to Serveur
    public static Serveur serveurDTOTOServeur(ServeurDTO serveurDTO) {
        if (serveurDTO == null) {
            return null;
        }

        Serveur serveur = new Serveur();
        serveur.setServeurId(serveurDTO.getServeurId());
        serveur.setHostName(serveurDTO.getHostName());
        serveur.setAddressIp(serveurDTO.getAdresseIp());
        serveur.setStatus(serveurDTO.getStatus());
        serveur.setSpecification(serveurDTO.getSpecification());

        if (serveurDTO.getCategoryServeur() != null) {
            CategoryServeur categoryServeur = CategoryServeurMapping.categoryServeurDTOToCategoryServeur(serveurDTO.getCategoryServeur());
            serveur.setCategoryServeur(categoryServeur);
        }

        if (serveurDTO.getClusters() != null) {
            Cluster cluster = ClusterMapping.clusterDTOToCluster(serveurDTO.getClusters());
            serveur.setCluster(cluster);
        }

        if (serveurDTO.getApplications() != null) {
            Collection<Application> applications = new ArrayList<>();
            for (ApplicationDTO applicationDTO : serveurDTO.getApplications()) {
                Application application = ApplicationMapping.applicationDTOToApplication(applicationDTO);
                applications.add(application);
            }
            serveur.setApplications(applications);
        }

        return serveur;
    }

    // Convert Serveur to ServeurDTO
    public static ServeurDTO serveurTOServeurDTO(Serveur serveur) {
        if (serveur == null) {
            return null;
        }

        ServeurDTO serveurDTO = new ServeurDTO();
        serveurDTO.setServeurId(serveur.getServeurId());
        serveurDTO.setHostName(serveur.getHostName());
        serveurDTO.setAdresseIp(serveur.getAddressIp());
        serveurDTO.setStatus(serveur.getStatus());
        serveurDTO.setSpecification(serveur.getSpecification());

        if (serveur.getCategoryServeur() != null) {
            CategoryServeurDTO categoryServeurDTO = CategoryServeurMapping.categoryServeurToCategoryServeurDTO(serveur.getCategoryServeur());
            serveurDTO.setCategoryServeur(categoryServeurDTO);
        }

        if (serveur.getCluster() != null) {
            ClusterDTO clusterDTO = ClusterMapping.clusterToClusterDTO(serveur.getCluster());
            serveurDTO.setClusters(clusterDTO);
        }

        if (serveur.getApplications() != null) {
            Collection<ApplicationDTO> applicationDTOs = new ArrayList<>();
            for (Application application : serveur.getApplications()) {
                ApplicationDTO applicationDTO = ApplicationMapping.applicationToApplicationDTO(application);
                applicationDTOs.add(applicationDTO);
            }
            serveurDTO.setApplications(applicationDTOs);
        }

        return serveurDTO;
    }

    // Convert Serveur to ServeurDTO with minimal fields
    public static ServeurDTO lazyServeurTOServeurDTO(Serveur serveur) {
        if (serveur == null) {
            return null;
        }

        ServeurDTO serveurDTO = new ServeurDTO();
        serveurDTO.setServeurId(serveur.getServeurId());
        serveurDTO.setHostName(serveur.getHostName());
        serveurDTO.setAdresseIp(serveur.getAddressIp());
        serveurDTO.setStatus(serveur.getStatus());
        serveurDTO.setSpecification(serveur.getSpecification());
        return serveurDTO;
    }

    // Convert a collection of Serveur entities to a collection of ServeurDTOs
    public static Collection<ServeurDTO> serveursToServeurDTOs(Collection<Serveur> serveurs) {
        List<ServeurDTO> serveurDTOs = new ArrayList<>();
        for (Serveur serveur : serveurs) {
            ServeurDTO serveurDTO = lazyServeurTOServeurDTO(serveur);
            serveurDTOs.add(serveurDTO);
        }
        return serveurDTOs;
    }
}
