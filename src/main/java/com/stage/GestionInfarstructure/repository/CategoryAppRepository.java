package com.stage.GestionInfarstructure.repository;

import com.stage.GestionInfarstructure.domain.CategoryApp;
import com.stage.GestionInfarstructure.domain.Reseau;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryAppRepository extends JpaRepository<CategoryApp, Integer> {
}
