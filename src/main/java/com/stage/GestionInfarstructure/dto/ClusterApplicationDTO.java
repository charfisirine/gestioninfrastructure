package com.stage.GestionInfarstructure.dto;

public class ClusterApplicationDTO {

    private Integer id;
    private ApplicationDTO application;
    private ClusterDTO cluster;
    private String status;

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ApplicationDTO getApplication() {
        return application;
    }

    public void setApplication(ApplicationDTO application) {
        this.application = application;
    }

    public ClusterDTO getCluster() {
        return cluster;
    }

    public void setCluster(ClusterDTO cluster) {
        this.cluster = cluster;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
