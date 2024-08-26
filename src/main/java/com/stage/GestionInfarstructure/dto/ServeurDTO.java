package com.stage.GestionInfarstructure.dto;

import java.util.Collection;

public class ServeurDTO {

    private Integer serveurId;
    private String hostName;
    private String adresseIp;
    private String status;
    private CategoryServeurDTO categoryServeur;
    private String specification;
    private ClusterDTO clusters;

    // Ajout de la collection de ServeurApplicationDTO
    private Collection<ServeurApplicationDTO> serveurApplications;

    // Getters et setters pour la collection de ServeurApplicationDTO
    public Collection<ServeurApplicationDTO> getServeurApplications() {
        return serveurApplications;
    }

    public void setServeurApplications(Collection<ServeurApplicationDTO> serveurApplications) {
        this.serveurApplications = serveurApplications;
    }

    public CategoryServeurDTO getCategoryServeur() {
        return categoryServeur;
    }

    public void setCategoryServeur(CategoryServeurDTO categoryServeur) {
        this.categoryServeur = categoryServeur;
    }

    public ClusterDTO getClusters() {
        return clusters;
    }

    public void setClusters(ClusterDTO clusters) {
        this.clusters = clusters;
    }

    public Integer getServeurId() {
        return serveurId;
    }

    public void setServeurId(Integer serveurId) {
        this.serveurId = serveurId;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getAdresseIp() {
        return adresseIp;
    }

    public void setAdresseIp(String adresseIp) {
        this.adresseIp = adresseIp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }
}
