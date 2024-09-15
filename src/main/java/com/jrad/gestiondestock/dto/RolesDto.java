package com.jrad.gestiondestock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jrad.gestiondestock.model.Roles;
import com.jrad.gestiondestock.model.Utilisateur;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RolesDto {
    private Integer id;
    private String roleName;

    @JsonIgnore
    private UtilisateurDto utilisateur;
    public static RolesDto fromEntity(Roles roles) {
        if (roles == null) {
            return null;
        }
        return RolesDto.builder()
                .id(roles.getId())
                .roleName(roles.getRoleName())
                .build();
    }

    public static Roles toEntity(RolesDto dto) {
        if (dto == null) {
            return null;
        }
        Roles roles = new Roles();
        roles.setId(dto.getId());
        roles.setRoleName(dto.getRoleName());

        return roles;
    }
}
