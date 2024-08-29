package com.stage.GestionInfarstructure.dto;

import java.util.Collection;
import jakarta.validation.constraints.Pattern;
public class SousReseauDTO {

    private Integer idSousReseau;
    private Integer idReseau;
    @Pattern(regexp = "^([0-9]{1,3}\\.){3}[0-9]{1,3}(\\/([1-9]|[1-2][0-9]|3[0-2]))?$",
            message = "Invalid IP Range format")
    private String ipRange;

    @Pattern(regexp = "^(?:[0-9]{1,3}\\.){3}[0-9]{1,3}$",
            message = "Invalid Gateway format")
    private String gateway;

    @Pattern(regexp = "^([0-9]{1,3}\\.){3}[0-9]{1,3}(\\/([1-9]|[1-2][0-9]|3[0-2]))?$",
            message = "Invalid CIDR notation format")
    private String CIDRnotation;

    @Pattern(regexp = "^(?:[0-9]{1,3}\\.){3}[0-9]{1,3}$",
            message = "Invalid  masque sous reseau format")
    private String masqueSousReseau;
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
