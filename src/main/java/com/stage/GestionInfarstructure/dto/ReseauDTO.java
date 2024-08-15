package com.stage.GestionInfarstructure.dto;

import java.util.Collection;
import java.util.List;

public class ReseauDTO {

    private Integer id;
    private String CIDRnotation;
    private String masqueSousReseau;
    private String ipRange;
    private String gateway;
    private Collection<SousReseauDTO> sousReseaux;

    public Integer getId() {
        return id;
    }

    public Collection<SousReseauDTO> getSousReseaux() {
        return sousReseaux;
    }

    public void setSousReseaux(Collection<SousReseauDTO> sousReseaux) {
        this.sousReseaux = sousReseaux;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
