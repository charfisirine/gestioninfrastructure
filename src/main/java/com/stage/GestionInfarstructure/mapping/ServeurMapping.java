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

        if (serveurDTO.getServeurApplications() != null) {
            Collection<ServeurApplication> serveurApplications = new ArrayList<>();
            for (ServeurApplicationDTO serveurApplicationDTO : serveurDTO.getServeurApplications()) {
                ServeurApplication serveurApplication = ServeurApplicationMapping.serveurApplicationDTOToServeurApplication(serveurApplicationDTO);
                serveurApplications.add(serveurApplication);
            }
            serveur.setServeurApplications(serveurApplications);
        }

        return serveur;
    }

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

        // Convertir la catégorie serveur si elle n'est pas nulle
        if (serveur.getCategoryServeur() != null) {
            CategoryServeurDTO categoryServeurDTO = CategoryServeurMapping.categoryServeurToCategoryServeurDTO(serveur.getCategoryServeur());
            serveurDTO.setCategoryServeur(categoryServeurDTO);
        }

        // Convertir le cluster si elle n'est pas nulle
        if (serveur.getCluster() != null) {
            ClusterDTO clusterDTO = ClusterMapping.clusterToClusterDTO(serveur.getCluster());
            serveurDTO.setClusters(clusterDTO);
        }

        // Convertir les applications serveur si elles ne sont pas nulles
        if (serveur.getServeurApplications() != null) {
            Collection<ServeurApplicationDTO> serveurApplicationDTOs = new ArrayList<>();
            for (ServeurApplication serveurApplication : serveur.getServeurApplications()) {
                ServeurApplicationDTO serveurApplicationDTO = ServeurApplicationMapping.serveurApplicationToServeurApplicationDTO(serveurApplication);
                serveurApplicationDTOs.add(serveurApplicationDTO);
            }
            serveurDTO.setServeurApplications(serveurApplicationDTOs);
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
            ServeurDTO serveurDTO = serveurTOServeurDTO(serveur);
            serveurDTOs.add(serveurDTO);
        }
        return serveurDTOs;
    }
}
