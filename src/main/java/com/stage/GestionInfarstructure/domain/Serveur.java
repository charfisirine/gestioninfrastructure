package com.stage.GestionInfarstructure.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Serveur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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
    @JoinColumn(name = "sousReseauId")  // Assurez-vous que `sousReseauId` est la clé étrangère correcte
    private SousReseau sousReseau;

    @ManyToMany
    @JoinTable(
            name = "Application_Serveur",
            joinColumns = @JoinColumn(name = "serveurId"),
            inverseJoinColumns = @JoinColumn(name = "applicationId")
    )
    private Collection<Application> applications;

    // Getters et setters

    public Serveur() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Collection<Application> getApplications() {
        return applications;
    }

    public void setApplications(Collection<Application> applications) {
        this.applications = applications;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Serveur serveur)) return false;
        return Objects.equals(id, serveur.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
