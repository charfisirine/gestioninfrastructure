package com.stage.GestionInfarstructure.dto;

import java.util.Collection;

public class ApplicationDTO {

    private Integer id;
    private String name;
    private String description;
    private Integer categoryApplId;
    private String lienAcces;
    private Integer serveurId;
    Collection<ServeurDTO> serveurs;
    Collection<ClusterDTO> clusters;

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

    public Integer getCategoryApplId() {
        return categoryApplId;
    }

    public void setCategoryApplId(Integer categoryApplId) {
        this.categoryApplId = categoryApplId;
    }

    public String getLienAcces() {
        return lienAcces;
    }

    public void setLienAcces(String lienAcces) {
        this.lienAcces = lienAcces;
    }

    public Integer getServeurId() {
        return serveurId;
    }

    public void setServeurId(Integer serveurId) {
        this.serveurId = serveurId;
    }
}
