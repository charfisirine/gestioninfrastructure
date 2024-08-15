package com.stage.GestionInfarstructure.dto;

import java.util.Collection;

public class ApplicationDTO {

    private Integer id;
    private String name;
    private String description;
    private String lienAcces;
    Collection<ServeurDTO> serveurs;
    Collection<ClusterDTO> clusters;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
