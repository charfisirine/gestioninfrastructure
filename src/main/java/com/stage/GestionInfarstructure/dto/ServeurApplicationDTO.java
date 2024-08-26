package com.stage.GestionInfarstructure.dto;

public class ServeurApplicationDTO {

    private Integer id;
    private String purpose;
    private String lienAcces;
    private ServeurDTO serveur;
    private ApplicationDTO application;

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getLienAcces() {
        return lienAcces;
    }

    public void setLienAcces(String lienAcces) {
        this.lienAcces = lienAcces;
    }

    public ServeurDTO getServeur() {
        return serveur;
    }

    public void setServeur(ServeurDTO serveur) {
        this.serveur = serveur;
    }

    public ApplicationDTO getApplication() {
        return application;
    }

    public void setApplication(ApplicationDTO application) {
        this.application = application;
    }
}
