package com.stage.GestionInfarstructure.mapping;

import com.stage.GestionInfarstructure.domain.Application;
import com.stage.GestionInfarstructure.domain.CategoryApp;
import com.stage.GestionInfarstructure.domain.Cluster;
import com.stage.GestionInfarstructure.domain.Serveur;
import com.stage.GestionInfarstructure.dto.ApplicationDTO;
import com.stage.GestionInfarstructure.dto.CategoryAppDTO;
import com.stage.GestionInfarstructure.dto.ClusterDTO;
import com.stage.GestionInfarstructure.dto.ServeurDTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ApplicationMapping {

    // Convert ApplicationDTO to Application
    public static Application applicationDTOToApplication(ApplicationDTO applicationDTO) {
        Application application = new Application();
        application.setApplicationId(applicationDTO.getApplicationId());
        application.setName(applicationDTO.getName());
        application.setDescription(applicationDTO.getDescription());

        if (applicationDTO.getCategoryApp() != null) {
            CategoryApp categoryApp = CategoryAppMapping.categoryAppDTOToCategoryApp(applicationDTO.getCategoryApp());
            application.setCategoryApp(categoryApp);
        }

        Collection<Serveur> serveurs = new ArrayList<>();
        if (applicationDTO.getServeurs() != null) {
            for (ServeurDTO serveurDTO : applicationDTO.getServeurs()) {
                Serveur serveur = ServeurMapping.serveurDTOTOServeur(serveurDTO);
                serveurs.add(serveur);
            }
        }
        application.setServeurs(serveurs);

        Collection<Cluster> clusters = new ArrayList<>();
        if (applicationDTO.getClusters() != null) {
            for (ClusterDTO clusterDTO : applicationDTO.getClusters()) {
                Cluster cluster = ClusterMapping.clusterDTOToCluster(clusterDTO);
                clusters.add(cluster);
            }
        }
        application.setCluster(clusters);

        return application;
    }

    // Convert Application to ApplicationDTO
    public static ApplicationDTO applicationToApplicationDTO(Application application) {
        if (application != null) {
            ApplicationDTO applicationDTO = new ApplicationDTO();
            applicationDTO.setApplicationId(application.getApplicationId());
            applicationDTO.setName(application.getName());
            applicationDTO.setDescription(application.getDescription());

            if (application.getCategoryApp() != null) {
                CategoryAppDTO categoryAppDTO = CategoryAppMapping.categoryAppToCategoryAppDTO(application.getCategoryApp());
                applicationDTO.setCategoryApp(categoryAppDTO);
            }

            if (application.getServeurs() != null) {
                applicationDTO.setServeurs(ServeurMapping.serveursToServeurDTOs(application.getServeurs()));
            }

            if (application.getCluster() != null) {
                applicationDTO.setClusters(ClusterMapping.clustersToClusterDTOs(application.getCluster()));
            }

            return applicationDTO;
        } else {
            return null;
        }
    }

    // Convert Application to ApplicationDTO with minimal fields
    public static ApplicationDTO lazyApplicationToApplicationDTO(Application application) {
        if (application != null) {
            ApplicationDTO applicationDTO = new ApplicationDTO();
            applicationDTO.setApplicationId(application.getApplicationId());
            applicationDTO.setName(application.getName());
            applicationDTO.setDescription(application.getDescription());
            return applicationDTO;
        } else {
            return null;
        }
    }

    // Convert a collection of Application entities to a collection of ApplicationDTOs
    public static Collection<ApplicationDTO> applicationsToApplicationDTOs(Collection<Application> applications) {
        List<ApplicationDTO> applicationDTOs = new ArrayList<>();
        for (Application application : applications) {
            ApplicationDTO applicationDTO = lazyApplicationToApplicationDTO(application);
            applicationDTOs.add(applicationDTO);
        }
        return applicationDTOs;
    }
}
