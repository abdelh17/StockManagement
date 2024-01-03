package com.abdel.stockmanagement.domain.entities;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "stockmovement")
public class StockMovement extends AbstractEntity {
    private Instant dateMovement;

    private BigDecimal quantity;

    @ManyToOne
    @JoinColumn(name = "idarticle")
    private Article article;

    @Enumerated(EnumType.STRING)
    private TypeMovement typeMovement;

    @Enumerated(EnumType.STRING)
    private SourceMovement sourceOfMovement;

    private Integer companyId;
}
