package com.stage.GestionInfarstructure.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Serveur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer serveurId;

    private String hostName;
    private String addressIp;
    private String status;
    private String specification;

    @ManyToOne
    @JoinColumn(name = "categoryServerId")
    private CategoryServeur categoryServeur;

    @ManyToOne
    @JoinColumn(name = "clusterId")
    private Cluster cluster;

    @ManyToOne
    @JoinColumn(name = "idSousReseau")
    private SousReseau sousReseau;

    // Ajout de la relation OneToMany avec ServeurApplication
    @OneToMany(mappedBy = "serveur", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<ServeurApplication> serveurApplications;

    public Integer getServeurId() {
        return serveurId;
    }

    public void setServeurId(Integer serveurId) {
        this.serveurId = serveurId;
    }

    // Constructeur par défaut
    public Serveur() {
    }

    // Getters et setters pour les autres champs
    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getAddressIp() {
        return addressIp;
    }

    public void setAddressIp(String addressIp) {
        this.addressIp = addressIp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public CategoryServeur getCategoryServeur() {
        return categoryServeur;
    }

    public void setCategoryServeur(CategoryServeur categoryServeur) {
        this.categoryServeur = categoryServeur;
    }

    public Cluster getCluster() {
        return cluster;
    }

    public void setCluster(Cluster cluster) {
        this.cluster = cluster;
    }

    public SousReseau getSousReseau() {
        return sousReseau;
    }

    public void setSousReseau(SousReseau sousReseau) {
        this.sousReseau = sousReseau;
    }

    public Collection<ServeurApplication> getServeurApplications() {
        return serveurApplications;
    }

    public void setServeurApplications(Collection<ServeurApplication> serveurApplications) {
        this.serveurApplications = serveurApplications;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Serveur serveur)) return false;
        return Objects.equals(serveurId, serveur.serveurId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(serveurId);
    }
}
