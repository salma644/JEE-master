package com.charge.charge.repositories;

import com.charge.charge.entities.Charge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChargeRepository extends JpaRepository<Charge, Integer> {


    // Méthodes pour récupérer, créer, modifier et supprimer des charges
@Query("select charge from Charge charge order by charge.title")
        List<Charge> findAllChargeByNameSort();
//trier par date du dernier delai
}


