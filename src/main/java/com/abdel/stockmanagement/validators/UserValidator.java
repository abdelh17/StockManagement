package com.abdel.stockmanagement.validators;

import com.abdel.stockmanagement.domain.dto.CategoryDto;
import com.abdel.stockmanagement.domain.dto.UserDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UserValidator {

    public static List<String> validate(UserDto dto){
        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("Missing user last name");
            errors.add("Missing user first name");
            errors.add("Missing user password");
            errors.add("Missing user email");
            errors.add("Missing user address");
            errors.add("Missing user birth date");
            return errors;
        }


        if(!StringUtils.hasLength(dto.getFname())){
            errors.add("Missing user first name");
        }
        if(!StringUtils.hasLength(dto.getLname())){
            errors.add("Missing user last name");
        }
        if(!StringUtils.hasLength(dto.getPassword())){
            errors.add("Missing user password");
        }
        if(!StringUtils.hasLength(dto.getEmail())){
            errors.add("Missing user email");
        }
        if (dto.getBirthDate() == null) {
            errors.add("Missing user birth date");
        }
        if(dto.getAddress()==null){
            errors.add("Missing user address");
        }else{
            if(dto.getAddress().getAddress1() == null)
                errors.add("The field address1 is mandatory");
            if(dto.getAddress().getCity() == null)
                errors.add("The field city is mandatory");
            if(dto.getAddress().getCountry() == null)
                errors.add("The field country is mandatory");
            if(dto.getAddress().getPostalCode() == null)
                errors.add("The field postalCode is mandatory");

        }
        return errors;

    }}
