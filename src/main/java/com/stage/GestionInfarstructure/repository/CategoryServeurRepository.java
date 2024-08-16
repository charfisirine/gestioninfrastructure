package com.stage.GestionInfarstructure.repository;

import com.stage.GestionInfarstructure.domain.CategoryServeur;
import com.stage.GestionInfarstructure.domain.Reseau;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryServeurRepository extends JpaRepository<CategoryServeur, Integer> {
}
