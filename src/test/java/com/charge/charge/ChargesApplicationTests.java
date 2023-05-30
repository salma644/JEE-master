package com.charge.charge;

import com.charge.charge.entities.Charge;
import com.charge.charge.entities.Famille;
import com.charge.charge.repositories.ChargeRepository;
import com.charge.charge.repositories.FamilleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ChargesApplicationTests {

	@Autowired
	ChargeRepository chargeRepository;
	@Autowired
	FamilleRepository familleRepository;
	@Test
	public void testCreateFamille() {
		Famille famille = new Famille("charges d'exploitation");
		famille = familleRepository.save(famille);
		Assertions.assertNotNull(famille.getId());
	}
	@Test
	public void testCreateCharge() {
		Famille famille = new Famille("Charges financières");
		famille = familleRepository.save(famille);
		Charge charge = new Charge("Loisir", 1000.0, LocalDate.now(), LocalDate.now().plusMonths(1), "Observation",famille);
		Charge savedCharge = chargeRepository.save(charge);
		assertNotNull(savedCharge.getId());
		assertEquals(charge.getTitle(), savedCharge.getTitle());
		assertEquals(charge.getMontant(), savedCharge.getMontant());
		assertEquals(charge.getDateDernierDelai(), savedCharge.getDateDernierDelai());
		assertEquals(charge.getDatePaiement(), savedCharge.getDatePaiement());
		assertEquals(charge.getObservation(), savedCharge.getObservation());
	}

	@Test
	public void testFindAllCharges() {
		List<Charge> charges = chargeRepository.findAll();
		assertEquals(1, charges.size());
	}

	@Test
	public void testFindChargeById() {
		Charge charge = chargeRepository.findById(1).orElse(null);
		assertNotNull(charge);
		assertEquals("Loyer", charge.getTitle());
	}

	@Test
	public void testUpdateCharge() {
		Charge charge = chargeRepository.findById(1).orElse(null);
		assertNotNull(charge);
		charge.setMontant(1200.0);
		Charge updatedCharge = chargeRepository.save(charge);
		assertEquals(1200.0, updatedCharge.getMontant());
	}

	@Test
	public void testDeleteCharge() {
		Charge charge = chargeRepository.findById(1).orElse(null);
		assertNotNull(charge);
		chargeRepository.delete(charge);
		Charge deletedCharge = chargeRepository.findById(1).orElse(null);
		assertNull(deletedCharge);
	}

}
