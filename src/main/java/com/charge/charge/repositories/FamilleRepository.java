package com.charge.charge.repositories;

import com.charge.charge.entities.Famille;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilleRepository extends JpaRepository<Famille, Integer> {
    // Méthodes pour récupérer, créer, modifier et supprimer des familles
}
