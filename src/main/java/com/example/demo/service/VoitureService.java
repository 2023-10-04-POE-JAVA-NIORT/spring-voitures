package com.example.demo.service;

import com.example.demo.dao.Voiture;
import com.example.demo.dao.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoitureService {

    @Autowired
    VoitureRepository voitureRepository;

    public List<Voiture> getVoitures(){
        return voitureRepository.findAll();
    }

    public Optional<Voiture> findById(Integer id){
        Optional<Voiture> optional = voitureRepository.findById(id);
        return optional;
    }

    public Voiture addVoiture(Voiture voiture){
        return voitureRepository.save(voiture);
    }

    public Voiture updateVoiture(Voiture voiture){
        return voitureRepository.save(voiture);
    }

    public boolean deleteVoiture(Integer id){
        if(findById(id).isEmpty())
            return false;
        else {
            voitureRepository.deleteById(id);
            return true;
        }
    }
}
