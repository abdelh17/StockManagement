package com.abdel.stockmanagement.domain.dto;

import com.abdel.stockmanagement.domain.entities.AbstractEntity;
import com.abdel.stockmanagement.domain.entities.Article;
import com.abdel.stockmanagement.domain.entities.SupplierOrder;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Builder
public class LineOrderSupplierDto {

    private Integer id;

    private ArticleDto article;

    private SupplierOrderDto supplierOrder;
    private BigDecimal quantity;
    private BigDecimal unitPrice;
}
