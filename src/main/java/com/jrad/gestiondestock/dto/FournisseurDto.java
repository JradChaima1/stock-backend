package com.jrad.gestiondestock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jrad.gestiondestock.model.Adresse;
import com.jrad.gestiondestock.model.CommandeFournisseur;
import com.jrad.gestiondestock.model.Fournisseur;
import com.jrad.gestiondestock.model.Utilisateur;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class FournisseurDto {

    private Integer id;
    private String nom;

    private String prenom;

    private AdresseDto adresse;

    private String photo;

    private String email;

    private String numTel;
    @JsonIgnore
    private List<CommandeFournisseurDto> commandefournisseurs;
    public static FournisseurDto fromEntity(Fournisseur fournisseur) {
        if (fournisseur == null) {
            return null;
        }
        return FournisseurDto.builder()
                .id(fournisseur.getId())
                .nom(fournisseur.getNom())
                .prenom(fournisseur.getPrenom())
                .adresse(AdresseDto.fromEntity(fournisseur.getAdresse()))
                .photo(fournisseur.getPhoto())
                .email(fournisseur.getEmail())
                .numTel(fournisseur.getNumTel())

                .build();
    }

    public static Fournisseur toEntity(FournisseurDto dto) {
        if (dto == null) {
            return null;
        }
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setId(dto.getId());
        fournisseur.setNom(dto.getNom());
        fournisseur.setPrenom(dto.getPrenom());
        fournisseur.setAdresse(AdresseDto.toEntity(dto.getAdresse()));
        fournisseur.setPhoto(dto.getPhoto());
        fournisseur.setEmail(dto.getEmail());
        fournisseur.setNumTel(dto.getNumTel());


        return fournisseur;
    }
}
