package com.stage.GestionInfarstructure.dto;

import java.util.ArrayList;
import java.util.Collection;

public class ReseauDTO {

    private Integer idReseau;
    private String name;  // Correspond à `name` dans la classe domaine
    private String ipRange;
    private String typeReseau;  // Correspond à `typeReseau` dans la classe domaine
    private Collection<SousReseauDTO> sousReseaux = new ArrayList<>();  // Utilisation de `Collection` pour correspondre à la classe domaine
    private SiteDTO site;  // Référence au DTO du site

    // Getters et Setters

    public Integer getIdReseau() {
        return idReseau;
    }

    public void setIdReseau(Integer idReseau) {
        this.idReseau = idReseau;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIpRange() {
        return ipRange;
    }

    public void setIpRange(String ipRange) {
        this.ipRange = ipRange;
    }

    public String getTypeReseau() {
        return typeReseau;
    }

    public void setTypeReseau(String typeReseau) {
        this.typeReseau = typeReseau;
    }

    public Collection<SousReseauDTO> getSousReseaux() {
        return sousReseaux;  // La collection est déjà initialisée
    }

    public void setSousReseaux(Collection<SousReseauDTO> sousReseaux) {
        this.sousReseaux = sousReseaux;
    }

    public SiteDTO getSite() {
        return site;
    }

    public void setSite(SiteDTO site) {
        this.site = site;
    }
}
