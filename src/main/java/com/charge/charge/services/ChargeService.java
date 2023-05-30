package com.charge.charge.services;

import com.charge.charge.entities.Charge;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ChargeService {
    List<Charge> getAllCharges();
    Charge getChargeById(int id) throws ChangeSetPersister.NotFoundException;
    Charge createCharge(Charge charge);
    Charge updateCharge(Charge charge);
    void deleteCharge(int id);

    Charge saveCharge(Charge charge);

    List<Charge> findAllChargeByNameSort();
    Page<Charge> getAllChargesByPage(int page,int size);
}
