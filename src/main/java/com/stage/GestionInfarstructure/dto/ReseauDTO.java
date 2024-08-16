package com.stage.GestionInfarstructure.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ReseauDTO {

    private Integer idReseau;
    private String name;  // Correspond à `name` dans la classe domaine
    private String ipRange;
    private String typeReseau;  // Correspond à `typeReseau` dans la classe domaine
    private Collection<SousReseauDTO> sousReseaux= new ArrayList<>();;  // Utilisation de `List` pour correspondre à la classe domaine

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
        if (sousReseaux == null) {
            sousReseaux = new ArrayList<>();
        }
        return sousReseaux;
    }

    public void setSousReseaux(Collection<SousReseauDTO> sousReseaux) {
        this.sousReseaux = sousReseaux;
    }
}
