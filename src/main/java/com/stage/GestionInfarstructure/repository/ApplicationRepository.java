package com.stage.GestionInfarstructure.repository;

import com.stage.GestionInfarstructure.domain.Reseau;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Reseau, Integer> {
}
