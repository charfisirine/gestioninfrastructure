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

    // Relation One-to-Many avec ServeurApplication
    @OneToMany(mappedBy = "application", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<ServeurApplication> serveurApplications;

    // Relation One-to-Many avec ClusterApplication
    @OneToMany(mappedBy = "application", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<ClusterApplication> clusterApplications;

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

    public Collection<ServeurApplication> getServeurApplications() {
        return serveurApplications;
    }

    public void setServeurApplications(Collection<ServeurApplication> serveurApplications) {
        this.serveurApplications = serveurApplications;
    }

    public Collection<ClusterApplication> getClusterApplications() {
        return clusterApplications;
    }

    public void setClusterApplications(Collection<ClusterApplication> clusterApplications) {
        this.clusterApplications = clusterApplications;
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
