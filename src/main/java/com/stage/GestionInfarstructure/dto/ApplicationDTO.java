package com.stage.GestionInfarstructure.dto;

import java.util.Collection;

public class ApplicationDTO {

    private Integer applicationId;
    private String name;
    private String description;
    private CategoryAppDTO categoryApp;
    private Collection<ServeurApplicationDTO> serveurApplications; // Collection pour ServeurApplicationDTO
    private Collection<ClusterApplicationDTO> clusterApplications; // Collection pour ClusterApplicationDTO

    public CategoryAppDTO getCategoryApp() {
        return categoryApp;
    }

    public void setCategoryApp(CategoryAppDTO categoryApp) {
        this.categoryApp = categoryApp;
    }

    public Integer getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<ServeurApplicationDTO> getServeurApplications() {
        return serveurApplications;
    }

    public void setServeurApplications(Collection<ServeurApplicationDTO> serveurApplications) {
        this.serveurApplications = serveurApplications;
    }

    public Collection<ClusterApplicationDTO> getClusterApplications() {
        return clusterApplications;
    }

    public void setClusterApplications(Collection<ClusterApplicationDTO> clusterApplications) {
        this.clusterApplications = clusterApplications;
    }
}
