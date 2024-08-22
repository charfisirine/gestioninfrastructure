package com.stage.GestionInfarstructure.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Application implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer applicationId;

    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "categoryApplId")
    private CategoryApp categoryApp;

    @ManyToMany
    @JoinTable(
            name = "Serveur_Application",
            joinColumns = @JoinColumn(name = "applicationId"),
            inverseJoinColumns = @JoinColumn(name = "serveurId")
    )
    private Collection<Serveur> serveurs;

    @ManyToMany(mappedBy = "applications")
    private Collection<Cluster> cluster;

    public CategoryApp getCategoryApp() {
        return categoryApp;
    }

    public void setCategoryApp(CategoryApp categoryApp) {
        this.categoryApp = categoryApp;
    }

    public Integer getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public Collection<Serveur> getServeurs() {
        return serveurs;
    }

    public void setServeurs(Collection<Serveur> serveurs) {
        this.serveurs = serveurs;
    }

    public Collection<Cluster> getCluster() {
        return cluster;
    }

    public void setCluster(Collection<Cluster> cluster) {
        this.cluster = cluster;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Application that)) return false;
        return Objects.equals(applicationId, that.applicationId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(applicationId);
    }
}
