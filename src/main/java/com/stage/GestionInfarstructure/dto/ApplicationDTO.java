package com.stage.GestionInfarstructure.dto;

import java.util.Collection;
import java.util.Collections;

public class ApplicationDTO {

    private Integer applicationId;
    private String name;
    private String description;
    private String lienAcces;
    private Collection<ServeurDTO> serveurs = Collections.emptyList();
    private Collection<ClusterDTO> clusters = Collections.emptyList();
    private CategoryAppDTO categoryApp;

    public Collection<ServeurDTO> getServeurs() {
        return serveurs;
    }

    public void setServeurs(Collection<ServeurDTO> serveurs) {
        this.serveurs = serveurs;
    }

    public Collection<ClusterDTO> getClusters() {
        return clusters;
    }

    public void setClusters(Collection<ClusterDTO> clusters) {
        this.clusters = clusters;
    }

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

    public String getLienAcces() {
        return lienAcces;
    }

    public void setLienAcces(String lienAcces) {
        this.lienAcces = lienAcces;
    }
}
