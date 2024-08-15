package com.stage.GestionInfarstructure.dto;

import java.util.Collection;

public class SousReseauDTO {

    private Integer idSousReseau;
    private Integer idReseau;  // Ajouté pour correspondre à `idReseau` dans la classe domaine
    private String CIDRnotation;  // Ajouté pour correspondre à `CIDRnotation` dans la classe domaine
    private String masqueSousReseau;
    private String ipRange;
    private String gateway;  // Ajouté pour correspondre à `gateway` dans la classe domaine
    private Collection<ServeurDTO> serveurs;

    // Getters and Setters


    public Integer getIdSousReseau() {
        return idSousReseau;
    }

    public void setIdSousReseau(Integer idSousReseau) {
        this.idSousReseau = idSousReseau;
    }

    public Integer getIdReseau() {
        return idReseau;
    }

    public void setIdReseau(Integer idReseau) {
        this.idReseau = idReseau;
    }

    public String getCIDRnotation() {
        return CIDRnotation;
    }

    public void setCIDRnotation(String CIDRnotation) {
        this.CIDRnotation = CIDRnotation;
    }

    public String getMasqueSousReseau() {
        return masqueSousReseau;
    }

    public void setMasqueSousReseau(String masqueSousReseau) {
        this.masqueSousReseau = masqueSousReseau;
    }

    public String getIpRange() {
        return ipRange;
    }

    public void setIpRange(String ipRange) {
        this.ipRange = ipRange;
    }

    public String getGateway() {
        return gateway;
    }

    public void setGateway(String gateway) {
        this.gateway = gateway;
    }

    public Collection<ServeurDTO> getServeurs() {
        return serveurs;
    }

    public void setServeurs(Collection<ServeurDTO> serveurs) {
        this.serveurs = serveurs;
    }
}
