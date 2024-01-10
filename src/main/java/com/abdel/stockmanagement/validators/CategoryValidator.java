package com.abdel.stockmanagement.validators;

import com.abdel.stockmanagement.domain.dto.CategoryDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CategoryValidator {
    public static List<String> validate(CategoryDto dto){
        List<String> errors = new ArrayList<>();

        if(!StringUtils.hasLength(dto.getCode())){
            errors.add("Missing Category");
        }
        return errors;

    }
}
