package com.stage.GestionInfarstructure.dto;

import java.util.List;

public class ReseauDTO {

    private Integer id;
    private String reseauId;
    private String CIDRnotation;
    private String masqueSousReseau;
    private String ipRange;
    private String gateway;
    private List<SousReseauDTO> sousReseaux;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReseauId() {
        return reseauId;
    }

    public void setReseauId(String reseauId) {
        this.reseauId = reseauId;
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
