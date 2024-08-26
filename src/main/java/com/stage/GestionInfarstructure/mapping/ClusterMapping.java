package com.stage.GestionInfarstructure.mapping;

import com.stage.GestionInfarstructure.domain.Cluster;
import com.stage.GestionInfarstructure.dto.ClusterDTO;
import com.stage.GestionInfarstructure.domain.Serveur;
import com.stage.GestionInfarstructure.dto.ServeurDTO;
import com.stage.GestionInfarstructure.domain.ClusterApplication;
import com.stage.GestionInfarstructure.dto.ClusterApplicationDTO;

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

        // Initialize serveurs if null
        Collection<Serveur> serveurs = new ArrayList<>();
        if (clusterDTO.getServeurs() != null) {
            for (ServeurDTO serveurDTO : clusterDTO.getServeurs()) {
                Serveur serveur = ServeurMapping.serveurDTOTOServeur(serveurDTO);
                serveurs.add(serveur);
                serveur.setCluster(cluster); // Set the cluster reference in Serveur
            }
        }
        cluster.setServeurs(serveurs);

        // Initialize clusterApplications if null
        Collection<ClusterApplication> clusterApplications = new ArrayList<>();
        if (clusterDTO.getClusterApplications() != null) {
            for (ClusterApplicationDTO clusterApplicationDTO : clusterDTO.getClusterApplications()) {
                ClusterApplication clusterApplication = ClusterApplicationMapping.clusterApplicationDTOToClusterApplication(clusterApplicationDTO);
                clusterApplications.add(clusterApplication);
                clusterApplication.setCluster(cluster); // Set the cluster reference in ClusterApplication
            }
        }
        cluster.setClusterApplications(clusterApplications); // Set the clusterApplications

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

            // Map the serveurs
            clusterDTO.setServeurs(ServeurMapping.serveursToServeurDTOs(cluster.getServeurs()));

            // Map the cluster applications
            clusterDTO.setClusterApplications(ClusterApplicationMapping.clusterApplicationsToClusterApplicationDTOs(cluster.getClusterApplications()));

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
