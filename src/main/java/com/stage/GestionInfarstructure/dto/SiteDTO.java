package com.stage.GestionInfarstructure.dto;

import java.util.Objects;

public class SiteDTO {

    private Integer id;
    private String designation;

    // Constructeur par défaut
    public SiteDTO() {
    }

    // Getter et setter pour id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        if (id != null && id < 0) {
            throw new IllegalArgumentException("ID must be a non-negative integer.");
        }
        this.id = id;
    }

    // Getter et setter pour designation
    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        if (designation != null && designation.trim().isEmpty()) {
            throw new IllegalArgumentException("Designation cannot be empty or whitespace only.");
        }
        this.designation = designation;
    }

    // Override de toString pour affichage simplifié
    @Override
    public String toString() {
        return "SiteDTO{" +
                "id=" + id +
                ", designation='" + designation + '\'' +
                '}';
    }

    // Override de equals et hashCode pour comparaison
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SiteDTO siteDTO = (SiteDTO) o;
        return Objects.equals(id, siteDTO.id) &&
                Objects.equals(designation, siteDTO.designation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, designation);
    }
}
