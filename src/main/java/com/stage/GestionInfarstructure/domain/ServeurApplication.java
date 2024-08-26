package com.stage.GestionInfarstructure.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class ServeurApplication implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String purpose;
    private String lienAcces;

    @ManyToOne
    @JoinColumn(name = "serveurId")
    private Serveur serveur;

    @ManyToOne
    @JoinColumn(name = "applicationId")
    private Application application;

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getLienAcces() {
        return lienAcces;
    }

    public void setLienAcces(String lienAcces) {
        this.lienAcces = lienAcces;
    }

    public Serveur getServeur() {
        return serveur;
    }

    public void setServeur(Serveur serveur) {
        this.serveur = serveur;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    // Equals and HashCode based on the primary key (id)

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ServeurApplication that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
