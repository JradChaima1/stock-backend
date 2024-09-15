package com.jrad.gestiondestock.dto;

import com.jrad.gestiondestock.model.Article;
import com.jrad.gestiondestock.model.MvtStk;
import com.jrad.gestiondestock.model.TypeMvtStk;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;
@Data
@Builder
public class MvtStkDto {

    private Integer id;
    private Instant dateMvt;


    private BigDecimal quantite;


    private ArticleDto article;



    private TypeMvtStk typeMvt;
    public static MvtStkDto fromEntity(MvtStk mvtStk) {
        if (mvtStk == null) {
            return null;
        }

        return MvtStkDto.builder()
                .id(mvtStk.getId())
                .dateMvt(mvtStk.getDateMvt())
                .quantite(mvtStk.getQuantite())
                .article(ArticleDto.fromEntity(mvtStk.getArticle()))
                .typeMvt(mvtStk.getTypeMvt())

                .build();
    }

    public static MvtStk toEntity(MvtStkDto dto) {
        if (dto == null) {
            return null;
        }

        MvtStk mvtStk = new MvtStk();
        mvtStk.setId(dto.getId());
        mvtStk.setDateMvt(dto.getDateMvt());
        mvtStk.setQuantite(dto.getQuantite());
        mvtStk.setArticle(ArticleDto.toEntity(dto.getArticle()));
        mvtStk.setTypeMvt(dto.getTypeMvt());


        return mvtStk;
    }
}
