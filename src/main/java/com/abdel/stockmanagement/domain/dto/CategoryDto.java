package com.abdel.stockmanagement.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CategoryDto {
    private Integer id;
    private String code;
    private String designation;
    @JsonIgnore
    private List<ArticleDto> articles;



}
