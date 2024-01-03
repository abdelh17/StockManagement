package com.abdel.stockmanagement.domain.dto;

import com.abdel.stockmanagement.domain.entities.AbstractEntity;
import com.abdel.stockmanagement.domain.entities.Sale;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Builder
public class LineSaleDto{
    private Integer id;

    private SaleDto sale;

    private BigDecimal quantity;

}
