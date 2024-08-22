package com.stage.GestionInfarstructure.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Reseau implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReseau;

    private String name;

    private String ipRange;

    private String typeReseau;

    @OneToMany(mappedBy = "reseau", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JsonIgnore
    private Collection<SousReseau> sousReseaux;

    @ManyToOne // Relation ManyToOne avec l'entité Site
    @JoinColumn(name = "site_id", nullable = false) // Nom de la colonne de jointure
    private Site site; // Attribut pour la relation avec Site

    public Reseau() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reseau reseau)) return false;
        return Objects.equals(idReseau, reseau.idReseau);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idReseau);
    }

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

    public Collection<SousReseau> getSousReseaux() {
        return sousReseaux;
    }

    public void setSousReseaux(Collection<SousReseau> sousReseaux) {
        this.sousReseaux = sousReseaux;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }
}
