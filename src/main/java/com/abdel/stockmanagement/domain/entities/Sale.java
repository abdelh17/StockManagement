package com.abdel.stockmanagement.domain.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="sale")
public class Sale extends AbstractEntity{
    private String code;

    private Instant dateSale;

    private String comment;

    private Integer companyId;

    @OneToMany(mappedBy = "sale")
    private List<LineSale> linesSale;
}
