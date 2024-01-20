package com.abdel.stockmanagement.domain.dto;

import com.abdel.stockmanagement.domain.entities.AbstractEntity;
import com.abdel.stockmanagement.domain.entities.Article;
import com.abdel.stockmanagement.domain.entities.Category;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleDto {

    private Integer id;
    private String codeArticle;
    private String designation;
    private BigDecimal unitPrice;
    private BigDecimal articleTaxRate;
    private BigDecimal priceFullTax;
    private String photo;
    private Category category;
    private Integer idCompany;


}
