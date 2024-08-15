package com.stage.GestionInfarstructure.dto;

import com.stage.GestionInfarstructure.domain.CategoryServeur;

import java.util.Collection;

public class ServeurDTO {

    private Integer id;
    private String hostName;
    private String adresseIp;
    private String status;
    private CategoryServeurDTO categoryServeur;
    private String specification;
    private Collection<ApplicationDTO> applications;
    private ClusterDTO clusters;

    public CategoryServeurDTO getCategoryServeur() {
        return categoryServeur;
    }

    public void setCategoryServeur(CategoryServeurDTO categoryServeur) {
        this.categoryServeur = categoryServeur;
    }

    public Collection<ApplicationDTO> getApplications() {
        return applications;
    }

    public void setApplications(Collection<ApplicationDTO> applications) {
        this.applications = applications;
    }

    public ClusterDTO getClusters() {
        return clusters;
    }

    public void setClusters(ClusterDTO clusters) {
        this.clusters = clusters;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
