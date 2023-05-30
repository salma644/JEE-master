package com.charge.charge.services;


import com.charge.charge.entities.Charge;
import com.charge.charge.entities.Famille;
import com.charge.charge.repositories.FamilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamilleServiceImp implements FamilleService{
    @Autowired
    private final FamilleRepository familleRepository;

    public FamilleServiceImp(FamilleRepository familleRepository) {
        this.familleRepository = familleRepository;
    }
    @Override
    public List<Famille> getAllFamilles() {
        return familleRepository.findAll();
    }
    @Override
    public Famille getFamilleById(int id) throws ChangeSetPersister.NotFoundException {
        return familleRepository.findById(id)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
    }
    @Override
    public Famille saveFamille(Famille famille) {
        return familleRepository.save(famille);
    }

    @Override
    public Famille createFamille(Famille famille) {
        return familleRepository.save(famille);
    }
    @Override
    public Famille updateFamille(Famille famille) {
        return familleRepository.save(famille);
    }
    @Override
    public void deleteFamille(int id) {
        familleRepository.deleteById(id);
    }
    @Override
    public Page<Famille> getAllFamillesByPage(int page, int size) {
        return familleRepository.findAll(PageRequest.of(page, size));
    }
}