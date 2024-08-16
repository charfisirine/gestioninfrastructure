package com.stage.GestionInfarstructure.mapping;

import com.stage.GestionInfarstructure.domain.Cluster;
import com.stage.GestionInfarstructure.dto.ClusterDTO;
import com.stage.GestionInfarstructure.domain.Application;
import com.stage.GestionInfarstructure.domain.Serveur;
import com.stage.GestionInfarstructure.dto.ApplicationDTO;
import com.stage.GestionInfarstructure.dto.ServeurDTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ClusterMapping {

    // Convert ClusterDTO to Cluster entity
    public static Cluster clusterDTOToCluster(ClusterDTO clusterDTO) {
        Cluster cluster = new Cluster();
        cluster.setClusterId(clusterDTO.getId());
        cluster.setName(clusterDTO.getName());
        cluster.setDescription(clusterDTO.getDescription());
        cluster.setType(clusterDTO.getType());
        cluster.setRole(clusterDTO.getRole());
        cluster.setStatus(clusterDTO.getStatus());
        cluster.setLocation(clusterDTO.getLocation());

        // Map the applications
        Collection<Application> applications = new ArrayList<>();
        for (ApplicationDTO applicationDTO : clusterDTO.getApplications()) {
            Application application = ApplicationMapping.applicationDTOTOApplication(applicationDTO);
            applications.add(application);
        }
        cluster.setApplications(applications);

        // Map the serveurs
        Collection<Serveur> serveurs = new ArrayList<>();
        for (ServeurDTO serveurDTO : clusterDTO.getServeurs()) {
            Serveur serveur = ServeurMapping.serveurDTOTOServeur(serveurDTO);
            serveurs.add(serveur);
            serveur.setCluster(cluster); // Set the cluster reference in Serveur
        }
        cluster.setServeurs(serveurs);

        return cluster;
    }

    // Convert Cluster entity to ClusterDTO
    public static ClusterDTO clusterToClusterDTO(Cluster cluster) {
        if (cluster != null) {
            ClusterDTO clusterDTO = new ClusterDTO();
            clusterDTO.setId(cluster.getClusterId());
            clusterDTO.setName(cluster.getName());
            clusterDTO.setDescription(cluster.getDescription());
            clusterDTO.setType(cluster.getType());
            clusterDTO.setRole(cluster.getRole());
            clusterDTO.setStatus(cluster.getStatus());
            clusterDTO.setLocation(cluster.getLocation());

            // Map the applications
            clusterDTO.setApplications(ApplicationMapping.applicationsToApplicationDTOs(cluster.getApplications()));

            // Map the serveurs
            clusterDTO.setServeurs(ServeurMapping.serveursToServeurDTOs(cluster.getServeurs()));

            return clusterDTO;
        } else {
            return null;
        }
    }

    // Convert a list of Clusters to ClusterDTOs (lazy loading without nested objects)
    public static Collection<ClusterDTO> clustersToClusterDTOs(Collection<Cluster> clusters) {
        List<ClusterDTO> clusterDTOs = new ArrayList<>();
        for (Cluster cluster : clusters) {
            ClusterDTO clusterDTO = lazyClusterToClusterDTO(cluster);
            clusterDTOs.add(clusterDTO);
        }
        return clusterDTOs;
    }

    // Convert a Cluster entity to a ClusterDTO without nested objects (lazy)
    public static ClusterDTO lazyClusterToClusterDTO(Cluster cluster) {
        if (cluster != null) {
            ClusterDTO clusterDTO = new ClusterDTO();
            clusterDTO.setId(cluster.getClusterId());
            clusterDTO.setName(cluster.getName());
            clusterDTO.setDescription(cluster.getDescription());
            clusterDTO.setType(cluster.getType());
            clusterDTO.setRole(cluster.getRole());
            clusterDTO.setStatus(cluster.getStatus());
            clusterDTO.setLocation(cluster.getLocation());
            return clusterDTO;
        } else {
            return null;
        }
    }
}
