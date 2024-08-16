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

    public static Application applicationDTOTOApplication(ApplicationDTO applicationDTO) {
        Application application = new Application();
        application.setApplicationId(applicationDTO.getId());
        application.setName(applicationDTO.getName());
        application.setDescription(applicationDTO.getDescription());
        application.setLienAccees(applicationDTO.getLienAcces());

        if (ApplicationDTO.getCategoryApp() != null) {
            CategoryApp categoryApp = CategoryAppMapping.categoryAppToCategoryAppDTO(ApplicationDTO.getCategoryApp());
            application.setCategoryApp(categoryApp);
        }

        Collection<Serveur> serveurs = new ArrayList<>();
        for (ServeurDTO serveurDTO : applicationDTO.getServeurs()) {
            Serveur serveur = ServeurMapping.serveurDTOTOServeur(serveurDTO);
            serveurs.add(serveur);
        }
        application.setServeurs(serveurs);

        Collection<Cluster> clusters = new ArrayList<>();
        for (ClusterDTO clusterDTO : applicationDTO.getClusters()) {
            Cluster cluster = ClusterMapping.clusterDTOToCluster(clusterDTO);
            clusters.add(cluster);
        }
        application.setCluster(clusters);

        return application;
    }

    public static ApplicationDTO applicationTOApplicationDTO(Application application) {
        if (application != null) {
            ApplicationDTO applicationDTO = new ApplicationDTO();
            applicationDTO.setId(application.getApplicationId());
            applicationDTO.setName(application.getName());
            applicationDTO.setDescription(application.getDescription());
            applicationDTO.setLienAcces(application.getLienAccees());

            if (application.getCategoryApp() != null) {
                CategoryAppDTO categoryAppDTO = CategoryAppMapping.categoryAppToCategoryAppDTO(application.getCategoryApp());
                applicationDTO.setCategoryApp(categoryAppDTO);
            }

            applicationDTO.setServeurs(ServeurMapping.serveursToServeurDTOs(application.getServeurs()));
            applicationDTO.setClusters(ClusterMapping.clustersToClusterDTOs(application.getCluster()));

            return applicationDTO;
        } else {
            return null;
        }
    }

    public static ApplicationDTO lazyApplicationTOApplicationDTO(Application application) {
        if (application != null) {
            ApplicationDTO applicationDTO = new ApplicationDTO();
            applicationDTO.setId(application.getApplicationId());
            applicationDTO.setName(application.getName());
            applicationDTO.setDescription(application.getDescription());
            applicationDTO.setLienAcces(application.getLienAccees());
            return applicationDTO;
        } else {
            return null;
        }
    }

    public static Collection<ApplicationDTO> applicationsToApplicationDTOs(Collection<Application> applications) {
        List<ApplicationDTO> applicationDTOs = new ArrayList<>();
        for (Application application : applications) {
            ApplicationDTO applicationDTO = lazyApplicationTOApplicationDTO(application);
            applicationDTOs.add(applicationDTO);
        }
        return applicationDTOs;
    }
}
