package com.stage.GestionInfarstructure.repository;

import com.stage.GestionInfarstructure.domain.Reseau;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClusterRepository extends JpaRepository<Reseau, Integer> {
}
