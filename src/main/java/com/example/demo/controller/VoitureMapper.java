package com.example.demo.controller;

import com.example.demo.dao.Voiture;

public class VoitureMapper {

    public static VoitureDTO entityToDto(Voiture entity){
        VoitureDTO voitureDTO = new VoitureDTO();

        voitureDTO.setBrand(entity.getMarque());
        voitureDTO.setColor(entity.getCouleur());
        voitureDTO.setModel(entity.getModele());
        voitureDTO.setYear(entity.getAnnee());

        return voitureDTO;
    }

    public static Voiture DtoToEntity(VoitureDTO dto){
        Voiture entity = new Voiture();
        entity.setAnnee(dto.getYear());
        entity.setCouleur(dto.getColor());
        entity.setMarque(dto.getBrand());
        entity.setModele(dto.getModel());
        return entity;
    }
}
