package com.stage.GestionInfarstructure.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;



import java.util.ArrayList;
import java.util.Collection;

public class ReseauDTO {

    private Integer idReseau;

    @NotBlank(message = "Le nom du réseau est necessaire.")
    @Size(max = 100, message = "Le nom du réseau ne doit pas dépasser 100 caractères.")
    private String name;

    @NotBlank(message = "L'intervalle d'IP est necessaire.")
    @Pattern(regexp = "^([0-9]{1,3}\\.){3}[0-9]{1,3}/[0-9]{1,2}$", message = "L'intervalle d'IP doit être au format CIDR (ex: 192.168.0.0/24).")
    private String ipRange;

    @NotBlank(message = "Le type de réseau est necessaire.")
    @Size(max = 50, message = "Le type de réseau ne doit pas dépasser 50 caractères.")
    private String typeReseau;

    @NotNull(message = "Le site est necessaire .")
    private SiteDTO site;

    private Collection<SousReseauDTO> sousReseaux = new ArrayList<>();

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

    public SiteDTO getSite() {
        return site;
    }

    public void setSite(SiteDTO site) {
        this.site = site;
    }

    public Collection<SousReseauDTO> getSousReseaux() {
        return sousReseaux;
    }

    public void setSousReseaux(Collection<SousReseauDTO> sousReseaux) {
        this.sousReseaux = sousReseaux;
    }
}
