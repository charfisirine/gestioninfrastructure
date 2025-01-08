package com.stage.GestionInfarstructure.mapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.stage.GestionInfarstructure.domain.CategoryServeur;
import com.stage.GestionInfarstructure.domain.Cluster;
import com.stage.GestionInfarstructure.domain.Serveur;
import com.stage.GestionInfarstructure.domain.ServeurApplication;
import com.stage.GestionInfarstructure.dto.CategoryServeurDTO;
import com.stage.GestionInfarstructure.dto.ClusterDTO;
import com.stage.GestionInfarstructure.dto.ServeurApplicationDTO;
import com.stage.GestionInfarstructure.dto.ServeurDTO;

public class ServeurMapping {

    // Convert ServeurDTO to Serveur
    public static Serveur serveurDTOTOServeur(ServeurDTO serveurDTO) {
        if (serveurDTO == null) {
            return null;
        }

        Serveur serveur = new Serveur();
        serveur.setServeurId(serveurDTO.getServeurId());
        serveur.setHostName(serveurDTO.getHostName());

        // Validation de l'adresse IP
        if (!isValidIpAddress(serveurDTO.getAdresseIp())) {
            throw new IllegalArgumentException("Invalid IP address format");
        }
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

    private static boolean isValidIpAddress(String ipAddress) {
        String ipPattern = "^(?:[0-9]{1,3}\\.){3}[0-9]{1,3}$";
        return ipAddress != null && ipAddress.matches(ipPattern);
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

        if (serveur.getCategoryServeur() != null) {
            CategoryServeurDTO categoryServeurDTO = CategoryServeurMapping.categoryServeurToCategoryServeurDTO(serveur.getCategoryServeur());
            serveurDTO.setCategoryServeur(categoryServeurDTO);
        }

        if (serveur.getCluster() != null) {
            ClusterDTO clusterDTO = new ClusterDTO();
            clusterDTO.setId(serveur.getCluster().getClusterId());
            clusterDTO.setName(serveur.getCluster().getName());

            serveurDTO.setClusters(clusterDTO);
        }

        if (serveur.getServeurApplications() != null) {
            List<ServeurApplicationDTO> applicationDTOs = serveur.getServeurApplications().stream()
                    .map(ServeurApplicationMapping::serveurApplicationToServeurApplicationDTO)
                    .collect(Collectors.toList());
            serveurDTO.setServeurApplications(applicationDTOs);
        }

        return serveurDTO;
    }

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
