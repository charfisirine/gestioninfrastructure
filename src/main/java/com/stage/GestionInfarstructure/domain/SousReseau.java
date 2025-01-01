package com.stage.GestionInfarstructure.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
public class SousReseau implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSousReseau;

    @Column(insertable = false, updatable = false)
    private Integer idReseau;

    private String CIDRnotation;
    private String masqueSousReseau;
    private String ipRange;
    private String gateway;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idReseau")
    private Reseau reseau;

    // Change ici : @OneToMany avec cascade et orphanRemoval
    @OneToMany(mappedBy = "sousReseau", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Collection<Serveur> serveurs;

    // Getters et setters

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

    public Reseau getReseau() {
        return reseau;
    }

    public void setReseau(Reseau reseau) {
        this.reseau = reseau;
    }

    public Collection<Serveur> getServeurs() {
        return serveurs;
    }

    public void setServeurs(Collection<Serveur> serveurs) {
        this.serveurs = serveurs;
    }

    // Change ici : méthode pour dissocier un serveur
    public void removeServeur(Serveur serveur) {
        if (serveurs != null && serveurs.contains(serveur)) {
            serveurs.remove(serveur);
            serveur.setSousReseau(null);  // Change ici : dissociation du côté de Serveur
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SousReseau that)) return false;
        return Objects.equals(idSousReseau, that.idSousReseau);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idSousReseau);
    }
}
