package com.charge.charge.services;

import com.charge.charge.entities.Charge;
import com.charge.charge.repositories.ChargeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChargeServiceImp implements ChargeService {
    @Autowired
    private final ChargeRepository chargeRepository;

    public ChargeServiceImp(ChargeRepository chargeRepository) {
        this.chargeRepository = chargeRepository;
    }
    @Override
    public List<Charge> getAllCharges() {
        return chargeRepository.findAll();
    }
    @Override
    public Charge getChargeById(int id) throws ChangeSetPersister.NotFoundException {
        return chargeRepository.findById(id)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
    }
    @Override
    public Charge createCharge(Charge charge) {
        return chargeRepository.save(charge);
    }
    @Override
    public Charge updateCharge(Charge charge) {
        return chargeRepository.save(charge);
    }
    @Override
    public void deleteCharge(int id) {
        chargeRepository.deleteById(id);
    }

    @Override
    public Charge saveCharge(Charge charge) {
        return chargeRepository.save(charge);
    }

    @Override
    public List<Charge> findAllChargeByNameSort() {
        return chargeRepository.findAllChargeByNameSort();
    }

    @Override
    public Page<Charge> getAllChargesByPage(int page, int size) {
        return chargeRepository.findAll(PageRequest.of(page, size));
    }
}

