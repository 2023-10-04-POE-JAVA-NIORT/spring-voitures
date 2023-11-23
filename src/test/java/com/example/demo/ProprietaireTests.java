package com.example.demo;

import com.example.demo.dao.Proprietaire;
import com.example.demo.dao.ProprietaireRepository;
import com.example.demo.dao.Voiture;
import com.example.demo.dao.VoitureRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProprietaireTests {

	@Autowired
	VoitureRepository voitureRepository;

	@Autowired
	ProprietaireRepository proprietaireRepository;

	@Test
	void testManyToOne(){
		Proprietaire jcd = new Proprietaire();
		jcd.setPrenom("Jean-Christophe");
		jcd.setNom("Dominguez");
		proprietaireRepository.save(jcd);
	}


}
