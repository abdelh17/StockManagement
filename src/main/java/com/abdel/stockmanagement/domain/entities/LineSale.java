package com.abdel.stockmanagement.domain.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Builder
@Entity
@Table(name="linesale")
public class LineSale extends AbstractEntity{
    @ManyToOne
    @JoinColumn(name = "idsale")
    private Sale sale;

    private BigDecimal quantity;

    private BigDecimal unitPrice;

}
