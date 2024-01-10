package com.abdel.stockmanagement.domain.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="lineorderclient")
public class LineOrderClient extends AbstractEntity{
    @ManyToOne
    @JoinColumn(name = "idarticle")
    private Article article;

    @ManyToOne
    @JoinColumn(name = "idclientorder")
    private ClientOrder clientOrder;

    private BigDecimal quantity;
    private BigDecimal unitPrice;



}
