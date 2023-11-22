package com.example.demo.controller;

import com.example.demo.dao.Voiture;
import com.example.demo.service.VoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class VoitureController {

    @Autowired
    VoitureService voitureService;

    @GetMapping("voitures")
    public List<Voiture> getAll(){
       return voitureService.getVoitures();
    }

    @PostMapping("voitures")
    public ResponseEntity<Voiture> addVoiture(@RequestBody Voiture newVoiture){
        Voiture voiture = voitureService.addVoiture(newVoiture);
        return ResponseEntity.ok(voiture);
    }

    @GetMapping("voitures/{id}")
    public ResponseEntity<Voiture> findById(@PathVariable Integer id){
        Optional<Voiture> optional = voitureService.findById(id);
        if(optional.isEmpty())
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(optional.get());
    }

    @DeleteMapping("voitures/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        if(voitureService.deleteVoiture(id))
            return ResponseEntity.ok().build();
        else
            return ResponseEntity.notFound().build();
    }

    @PutMapping("voitures/{id}")
    public ResponseEntity update(@RequestBody Voiture voiture, @PathVariable Integer id){
        if(!voiture.getId().equals(id))
            return ResponseEntity.badRequest().build();

        // verifier éventuellement les champs vides ou valeurs non acceptable
        // TODO

        // on refuse de faire un update si id inexistant
        Optional<Voiture> optional = voitureService.findById(id);
        if(optional.isEmpty())
            return ResponseEntity.notFound().build();

        Voiture voitureDatabase = voitureService.updateVoiture(voiture);
        return ResponseEntity.ok(voitureDatabase);
    }
}
