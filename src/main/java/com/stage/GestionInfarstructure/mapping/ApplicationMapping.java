package com.stage.GestionInfarstructure.mapping;

import com.stage.GestionInfarstructure.domain.Application;
import com.stage.GestionInfarstructure.domain.CategoryApp;
import com.stage.GestionInfarstructure.dto.ApplicationDTO;
import com.stage.GestionInfarstructure.dto.CategoryAppDTO;
import com.stage.GestionInfarstructure.dto.ClusterApplicationDTO;
import com.stage.GestionInfarstructure.dto.ServeurApplicationDTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ApplicationMapping {

    // Convert ApplicationDTO to Application
    public static Application applicationDTOToApplication(ApplicationDTO applicationDTO) {
        if (applicationDTO == null) {
            return null;
        }

        Application application = new Application();
        application.setApplicationId(applicationDTO.getApplicationId());
        application.setName(applicationDTO.getName());
        application.setDescription(applicationDTO.getDescription());

        // Map CategoryApp
        if (applicationDTO.getCategoryApp() != null) {
            CategoryApp categoryApp = CategoryAppMapping.categoryAppDTOToCategoryApp(applicationDTO.getCategoryApp());
            application.setCategoryApp(categoryApp);
        }

        return application;
    }

    // Convert Application to ApplicationDTO with selected fields
    public static ApplicationDTO applicationToApplicationDTO(Application application) {
        if (application == null) {
            return null;
        }

        ApplicationDTO applicationDTO = new ApplicationDTO();
        applicationDTO.setApplicationId(application.getApplicationId());
        applicationDTO.setName(application.getName());
        applicationDTO.setDescription(application.getDescription());

        // Map CategoryApp if exists
        if (application.getCategoryApp() != null) {
            CategoryAppDTO categoryAppDTO = CategoryAppMapping.categoryAppToCategoryAppDTO(application.getCategoryApp());
            applicationDTO.setCategoryApp(categoryAppDTO);
        }

        return applicationDTO;
    }

    // Convert Application to ApplicationDTO with minimal fields
    public static ApplicationDTO lazyApplicationToApplicationDTO(Application application) {
        if (application == null) {
            return null;
        }

        ApplicationDTO applicationDTO = new ApplicationDTO();
        applicationDTO.setApplicationId(application.getApplicationId());
        applicationDTO.setName(application.getName());
        applicationDTO.setDescription(application.getDescription());

        // Map CategoryApp if exists
        if (application.getCategoryApp() != null) {
            CategoryAppDTO categoryAppDTO = CategoryAppMapping.categoryAppToCategoryAppDTO(application.getCategoryApp());
            applicationDTO.setCategoryApp(categoryAppDTO);
        }

        // Map ServeurApplications if exists
        if (application.getServeurApplications() != null && !application.getServeurApplications().isEmpty()) {
            Collection<ServeurApplicationDTO> serveurApplicationDTOs = application.getServeurApplications().stream()
                    .map(serveurApplication -> ServeurApplicationMapping.serveurApplicationToServeurApplicationDTO(serveurApplication))
                    .collect(Collectors.toList());
            applicationDTO.setServeurApplications(serveurApplicationDTOs);
        }

        // Map ClusterApplications if exists
        if (application.getClusterApplications() != null && !application.getClusterApplications().isEmpty()) {
            Collection<ClusterApplicationDTO> clusterApplicationDTOs = application.getClusterApplications().stream()
                    .map(clusterApplication -> ClusterApplicationMapping.clusterApplicationToClusterApplicationDTO(clusterApplication))
                    .collect(Collectors.toList());
            applicationDTO.setClusterApplications(clusterApplicationDTOs);
        }

        return applicationDTO;
    }


    // Convert a collection of Application entities to a collection of ApplicationDTOs
    public static Collection<ApplicationDTO> applicationsToApplicationDTOs(Collection<Application> applications) {
        List<ApplicationDTO> applicationDTOs = new ArrayList<>();
        for (Application application : applications) {
            applicationDTOs.add(lazyApplicationToApplicationDTO(application));
        }
        return applicationDTOs;
    }
}
