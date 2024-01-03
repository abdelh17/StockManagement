package com.abdel.stockmanagement.domain.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="category")
public class Category extends AbstractEntity{
    private String code;
    private String designation;
    @OneToMany(mappedBy = "category") //1 category has many articles
    private List<Article> articles;

}
