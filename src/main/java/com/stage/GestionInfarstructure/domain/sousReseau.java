package com.stage.GestionInfarstructure.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
public class sousReseau implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String reseauId;
    private String CIDRnotation;
    private String masqueSousReseau;
    private String ipRange;
    private String gateway;

    public sousReseau() {
    }

    @ManyToOne
    @JoinColumn(name = "reseauId")
    private Reseau reseau;


    @OneToMany(mappedBy = "sousReseau", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnore
    private Collection<Serveur> serveurs;




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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof sousReseau that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
