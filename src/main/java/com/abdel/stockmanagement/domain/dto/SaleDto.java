package com.abdel.stockmanagement.domain.dto;

import com.abdel.stockmanagement.domain.entities.AbstractEntity;
import com.abdel.stockmanagement.domain.entities.LineSale;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.Instant;
import java.util.List;

@Data
@Builder
public class SaleDto {
    private Integer id;

    private String code;

    private Instant dateSale;

    private String comment;
    private List<LineSaleDto> linesSale;
}
