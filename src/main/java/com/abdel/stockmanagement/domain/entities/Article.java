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
@EqualsAndHashCode(callSuper = true)
@Builder
@Entity
@Table(name="article")
public class Article extends AbstractEntity{

    private String codeArticle;
    private String designation;
    private BigDecimal unitPrice;
    private BigDecimal articleTaxRate;
    private BigDecimal priceFullTax;
    private String photo;
    private Integer idCompany;

    @ManyToOne //many articles for 1 category
    @JoinColumn(name = "idcategory")
    private Category category;

}
