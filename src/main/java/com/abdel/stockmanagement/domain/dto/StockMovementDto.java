package com.abdel.stockmanagement.domain.dto;

import com.abdel.stockmanagement.domain.entities.AbstractEntity;
import com.abdel.stockmanagement.domain.entities.Article;
import com.abdel.stockmanagement.domain.entities.SourceMovement;
import com.abdel.stockmanagement.domain.entities.TypeMovement;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;


@Data
@Builder
public class StockMovementDto{
    private Integer id;

    private Instant dateMovement;

    private BigDecimal quantity;

    private ArticleDto article;

    private TypeMovement typeMovement;

    private SourceMovement sourceOfMovement;

    private Integer companyId;
}
