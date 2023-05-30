package com.charge.charge.services;

import com.charge.charge.entities.Famille;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;

import java.util.List;

public interface FamilleService {
    List<Famille> getAllFamilles();
    Famille getFamilleById(int id) throws ChangeSetPersister.NotFoundException;
    Famille createFamille(Famille famille);
    Famille updateFamille(Famille famille);

    Famille saveFamille(Famille famille);
    void deleteFamille(int id);
    Page<Famille> getAllFamillesByPage(int page, int size);
}
