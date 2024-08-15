package com.stage.GestionInfarstructure.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Reseau implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String ipRange;

    private String typeReseau;

    @OneToMany(mappedBy = "reseau", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnore
    private List<sousReseau> sousReseaux;



    public Reseau() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reseau reseau)) return false;
        return Objects.equals(id, reseau.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
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

    public List<sousReseau> getSousReseaux() {
        return sousReseaux;
    }

    public void setSousReseaux(List<sousReseau> sousReseaux) {
        this.sousReseaux = sousReseaux;
    }
}
