package com.stage.GestionInfarstructure.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Entity
public class Application implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String description;
    private String lienAccees;

    @ManyToOne
    @JoinColumn(name = "categoryApplId")
    private CategoryApp categoryApp; // Relation Many-to-One avec CategoryApplication

    @ManyToOne
    @JoinColumn(name = "serveurId")
    private Serveur serveur; // Relation Many-to-One avec Serveur


    @ManyToMany
    @JoinTable(
            name = "cluster",
            joinColumns = @JoinColumn(name = "applicationId"),
            inverseJoinColumns = @JoinColumn(name = "clusterId")
    )
    private Collection<Cluster> clusters; // Relation Many-to-Many avec Cluster

    public Application() {
    }

    public void setCategoryApp(CategoryApp categoryApp) {
        this.categoryApp = categoryApp;
    }

    public Collection<Cluster> getClusters() {
        return clusters;
    }

    public void setClusters(Collection<Cluster> clusters) {
        this.clusters = clusters;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Application that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
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

    public String getLienAccees() {
        return lienAccees;
    }

    public void setLienAccees(String lienAccees) {
        this.lienAccees = lienAccees;
    }

    public CategoryApp getCategoryApp() {
        return categoryApp;
    }

    public void setCategoryApplication(CategoryApp categoryApp) {
        this.categoryApp = categoryApp;
    }

    public Serveur getServeur() {
        return serveur;
    }

    public void setServeur(Serveur serveur) {
        this.serveur = serveur;
    }
}
