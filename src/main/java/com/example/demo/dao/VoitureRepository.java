package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoitureRepository extends JpaRepository<Voiture, Integer> {

    public List<Voiture> findAllByMarque(String marque);
    public List<Voiture> findAllByMarqueAndCouleur(String marque, String couleur);


    @Query(value = "SELECT * FROM voitures WHERE couleur='bleu'", nativeQuery = true)
    public List<Voiture> retourneVoituresBleu();
}