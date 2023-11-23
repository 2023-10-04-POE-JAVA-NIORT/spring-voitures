package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoitureRepository extends JpaRepository<Voiture, Integer> {

    // Doc avec les mots clés:
    // https://docs.spring.io/spring-data/data-commons/docs/current/reference/html/#appendix.query.method.subject
    public List<Voiture> findAllByMarque(String marque);

    // SELECT * FROM voitures v WHERE v.marque=? AND v.couleur=?
    public List<Voiture> findAllByMarqueAndCouleur(String marque, String couleur);


    // Alternative vous permettant d'écrire du vrai SQL
    @Query(value = "SELECT * FROM voitures WHERE couleur='bleu'", nativeQuery = true)
    public List<Voiture> retourneVoituresBleu();
}