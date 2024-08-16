package com.stage.GestionInfarstructure.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.*;

@Entity
public class Cluster implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clusterId")
    private Integer clusterId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "type", nullable = false)
    private String type;



    @Column(name = "role", nullable = false)
    private String role;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "location", nullable = false)
    private String location;

    @ManyToMany
    @JoinTable(
            name = "cluster_application",
            joinColumns = @JoinColumn(name = "clusterId"),
            inverseJoinColumns = @JoinColumn(name = "applicationId")
    )
    private Collection<Application> applications ;

    @OneToMany(mappedBy = "cluster", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnore
    private Collection<Serveur> serveurs;


    public Cluster() {
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Collection<Application> getApplications() {
        return applications;
    }

    public Collection<Serveur> getServeurs() {
        return serveurs;
    }

    public void setServeurs(Collection<Serveur> serveurs) {
        this.serveurs = serveurs;
    }

    public void setApplications(Collection<Application> applications) {
        this.applications = applications;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cluster cluster)) return false;
        return Objects.equals(clusterId, cluster.clusterId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(clusterId);
    }



    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getClusterId() {
        return clusterId;
    }

    public void setClusterId(Integer clusterId) {
        this.clusterId = clusterId;
    }
}
