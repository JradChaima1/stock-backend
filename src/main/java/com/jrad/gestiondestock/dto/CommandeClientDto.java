package com.jrad.gestiondestock.dto;

import com.jrad.gestiondestock.model.Client;
import com.jrad.gestiondestock.model.CommandeClient;
import com.jrad.gestiondestock.model.LigneCommandeClient;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;
@Data
@Builder
public class CommandeClientDto {
    private Integer id;
    private String code;
    private Instant dateCommande;

    private ClientDto client;

    private List<LigneCommandeClientDto> ligneCommandeClients;
    public static CommandeClientDto fromEntity(CommandeClient commandeClient) {
        if (commandeClient == null) {
            return null;
        }
        return CommandeClientDto.builder()
                .id(commandeClient.getId())
                .code(commandeClient.getCode())
                .dateCommande(commandeClient.getDateCommande())

                .client(ClientDto.fromEntity(commandeClient.getClient()))

                .build();

    }

    public static CommandeClient toEntity(CommandeClientDto dto) {
        if (dto == null) {
            return null;
        }
        CommandeClient commandeClient = new CommandeClient();
        commandeClient.setId(dto.getId());
        commandeClient.setCode(dto.getCode());
        commandeClient.setClient(ClientDto.toEntity(dto.getClient()));
        commandeClient.setDateCommande(dto.getDateCommande());
        return commandeClient;
    }

}
