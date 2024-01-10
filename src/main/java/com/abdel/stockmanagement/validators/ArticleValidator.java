package com.abdel.stockmanagement.validators;

import com.abdel.stockmanagement.domain.dto.ArticleDto;
import com.abdel.stockmanagement.domain.dto.CategoryDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ArticleValidator {

    public static List<String> validate(ArticleDto dto){
        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("Missing article code");
            errors.add("Missing article designation");
            errors.add("Missing article tax rate");
            errors.add("Missing article unit price");
            errors.add("Missing article full price");
            errors.add("Missing article category");
            return errors;
        }

        if(!StringUtils.hasLength(dto.getCodeArticle())){
            errors.add("Missing article code");
        }
        if(!StringUtils.hasLength(dto.getDesignation())){
            errors.add("Missing article designation");
        }
        if(dto.getArticleTaxRate() == null){
            errors.add("Missing article tax rate");
        }
        if(dto.getUnitPrice() == null){
            errors.add("Missing article unit price");
        }
        if(dto.getPriceFullTax() == null){
            errors.add("Missing article full price");
        }
        if(dto.getCategory()==null || dto.getCategory().getId()==null){
            errors.add("Missing article category");
        }
        return errors;


    }
}
