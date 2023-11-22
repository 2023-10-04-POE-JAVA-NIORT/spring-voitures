package com.example.demo.controller;

import com.example.demo.dao.Voiture;
import com.example.demo.service.VoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class VoitureController {

    @Autowired
    VoitureService voitureService;

    @GetMapping("voitures")
    public List<VoitureDTO> getAll(){
        List<Voiture> voitures = voitureService.getVoitures();
        List<VoitureDTO> voituresDTO = new ArrayList<>();

        for (Voiture entity : voitures) {

            VoitureDTO dto = VoitureMapper.entityToDto(entity);
            voituresDTO.add(dto);
        }

        return voituresDTO;
    }

    @PostMapping("voitures")
    public ResponseEntity<Voiture> addVoiture(@RequestBody VoitureDTO newVoiture){


        Voiture voiture = voitureService.addVoiture(
                VoitureMapper.DtoToEntity(newVoiture));
        return ResponseEntity.ok(voiture);
    }

    @GetMapping("voitures/{id}")
    public ResponseEntity<VoitureDTO> findById(@PathVariable Integer id){
        Optional<Voiture> optional = voitureService.findById(id);
        if(optional.isEmpty())
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(VoitureMapper.entityToDto(optional.get()));
    }

    @DeleteMapping("voitures/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        if(voitureService.deleteVoiture(id))
            return ResponseEntity.ok().build();
        else
            return ResponseEntity.notFound().build();
    }

    @PutMapping("voitures/{id}")
    public ResponseEntity<VoitureDTO> update(@RequestBody VoitureDTO voiture, @PathVariable Integer id){
        //if(!voiture.getId().equals(id))
          //  return ResponseEntity.badRequest().build();

        // verifier éventuellement les champs vides ou valeurs non acceptable
        // TODO

        // on refuse de faire un update si id inexistant
        Optional<Voiture> optional = voitureService.findById(id);
        if(optional.isEmpty())
            return ResponseEntity.notFound().build();

        Voiture voitureDatabase = voitureService.updateVoiture(VoitureMapper.DtoToEntity(voiture));
        return ResponseEntity.ok(VoitureMapper.entityToDto(voitureDatabase));
    }
}
