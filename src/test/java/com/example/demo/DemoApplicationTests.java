package com.example.demo;

import com.example.demo.dao.Voiture;
import com.example.demo.dao.VoitureRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	VoitureRepository voitureRepository;

	@Test
	void voiture() {

		List<Voiture> voitures =  voitureRepository.findAllByMarque("Mercedes");
		for(Voiture v : voitures)
			System.out.println(v);
	}

}
