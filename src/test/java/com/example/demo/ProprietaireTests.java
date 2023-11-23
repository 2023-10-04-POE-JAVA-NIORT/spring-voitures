package com.example.demo;

import com.example.demo.dao.Proprietaire;
import com.example.demo.dao.ProprietaireRepository;
import com.example.demo.dao.Voiture;
import com.example.demo.dao.VoitureRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class ProprietaireTests {

	@Autowired
	VoitureRepository voitureRepository;

	@Autowired
	ProprietaireRepository proprietaireRepository;

	@Test
	void createPropritaire(){
		Proprietaire jcd = new Proprietaire();
		jcd.setPrenom("Jean-Christophe");
		jcd.setNom("Dominguez");
		proprietaireRepository.save(jcd);
	}
	@Test
	void testManyToOne(){
		Optional<Proprietaire> op = proprietaireRepository.findById(1);
		if(op.isPresent()) {
			Proprietaire jcd = op.get();

			Voiture v = new Voiture();
			v.setMarque("Opel");
			v.setModele("Astra");
			v.setProprietaire(jcd);
			voitureRepository.save(v);
		}
	}


	@Test
	void lireVoiture(){
		Optional<Voiture> optional = voitureRepository.findById(8);
		if(optional.isPresent()){
			Voiture voiture = optional.get();
			System.out.println(voiture);
		} else
			System.out.println("id non trouvé");
	}

}
