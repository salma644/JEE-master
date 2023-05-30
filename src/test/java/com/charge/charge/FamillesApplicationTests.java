/*package com.charge.charge;

import com.charge.charge.entities.Famille;
import com.charge.charge.repositories.ChargeRepository;
import com.charge.charge.repositories.FamilleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@SpringBootTest
public class FamillesApplicationTests {

    @Autowired
    FamilleRepository familleRepository;

    @Autowired
    ChargeRepository chargeRepository;

    @Test
    public void testCreateFamille() {
        Famille famille = new Famille("charges d'exploitation");
        famille = familleRepository.save(famille);
        Assertions.assertNotNull(famille.getId());
    }

    @Test
    public void testFindFamilleById() {
        Famille famille = new Famille("charges d'exploitation");
        famille = familleRepository.save(famille);
        Famille foundFamille = familleRepository.findById(famille.getId()).orElse(null);
        Assertions.assertEquals(famille, foundFamille);
    }

    @Test
    public void testFindAllFamilles() {
        Famille famille1 = new Famille("charges d'exploitation");
        famille1 = familleRepository.save(famille1);
        Famille famille2 = new Famille("charges financières");
        famille2 = familleRepository.save(famille2);
        List<Famille> familles = familleRepository.findAll();
        Assertions.assertEquals(2, familles.size());
        Assertions.assertTrue(familles.contains(famille1));
        Assertions.assertTrue(familles.contains(famille2));
    }

    @Test
    public void testUpdateFamille() {
        Famille famille = new Famille("charges d'exploitation");
        famille = familleRepository.save(famille);
        famille.setLibelle("charges d'exploitation et financières");
        famille = familleRepository.save(famille);
        Assertions.assertEquals("charges d'exploitation et financières", famille.getLibelle());
    }

    @Test
    public void testDeleteFamille() {
        Famille famille = new Famille("charges d'exploitation");
        famille = familleRepository.save(famille);
        familleRepository.deleteById(famille.getId());
        Famille foundFamille = familleRepository.findById(famille.getId()).orElse(null);
        Assertions.assertNull(foundFamille);
    }

    @Test
    public void testAddChargeToFamille() {
        Famille famille = new Famille("charges d'exploitation");
        famille = familleRepository.save(famille);
        Charge charge1 = new Charge("Charge 1", 100);
        charge1.setFamille(famille);
        Charge charge2 = new Charge("Charge 2", 200);
        charge2.setFamille(famille);
        chargeRepository.save(charge1);
        chargeRepository.save(charge2);
        Famille foundFamille = familleRepository.findById(famille.getId()).orElse(null);
        Assertions.assertEquals(2, foundFamille.getCharges().size());
        Assertions.assertTrue(foundFamille.getCharges().contains(charge1));
        Assertions.assertTrue(foundFamille.getCharges().contains(charge2));
    }

}
*/