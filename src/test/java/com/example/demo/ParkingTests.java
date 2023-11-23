package com.example.demo;

import com.example.demo.dao.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class ParkingTests {

	@Autowired
	VoitureRepository voitureRepository;

	@Autowired
	ParkingRepository parkingRepository;

	@Test
	void testManyToMany(){

		Optional<Voiture> op1 = voitureRepository.findById(1);
		Optional<Voiture> op3 = voitureRepository.findById(3);
		Optional<Voiture> op4 = voitureRepository.findById(4);
		Optional<Voiture> op5 = voitureRepository.findById(5);

		if(op1.isPresent() && op3.isPresent() && op4.isPresent() && op5.isPresent()) {

			Voiture v1 = op1.get();
			Voiture v2 = op3.get();
			Voiture v3 = op4.get();
			Voiture v4 = op5.get();

			Parking p1 = new Parking();
			p1.setNumero(34);
			p1.setRue("rue de la paix");
			p1.addVoiture(v1);
			p1.addVoiture(v2);
			parkingRepository.save(p1);

			Parking p2 = new Parking();
			p2.setNumero(13);
			p2.setRue("rue de la loge");
			p2.addVoiture(v3);
			p2.addVoiture(v2);
			parkingRepository.save(p2);

		}

	}

	@Test
	void lireParking(){
		Optional<Parking> optional =  parkingRepository.findById(4);
		if(optional.isPresent()){
			Parking parking = optional.get();

			System.out.println(parking);

			System.out.println(parking.getVoitures().size());
			for(Voiture v : parking.getVoitures())
				System.out.println(v);
		}
	}

}
