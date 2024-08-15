package com.stage.GestionInfarstructure.dto;

import java.util.Collection;

public class ClusterDTO {

    private Integer id;
    private String name;  // Correspond à `name` dans la classe domaine
    private String description;
    private String type;
    private String role;  // Ajouté pour correspondre à `role` dans la classe domaine
    private String status;
    private String location;
    private Collection<ServeurDTO> serveurs;
    private Collection<ApplicationDTO> applications;

    // Getters et Setters

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Collection<ServeurDTO> getServeurs() {
        return serveurs;
    }

    public void setServeurs(Collection<ServeurDTO> serveurs) {
        this.serveurs = serveurs;
    }

    public Collection<ApplicationDTO> getApplications() {
        return applications;
    }

    public void setApplications(Collection<ApplicationDTO> applications) {
        this.applications = applications;
    }
}
