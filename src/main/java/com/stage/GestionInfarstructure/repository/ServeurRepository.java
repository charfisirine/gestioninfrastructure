package com.stage.GestionInfarstructure.repository;

import com.stage.GestionInfarstructure.domain.Reseau;
import com.stage.GestionInfarstructure.domain.Serveur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServeurRepository extends JpaRepository<Serveur, Integer> {
}
