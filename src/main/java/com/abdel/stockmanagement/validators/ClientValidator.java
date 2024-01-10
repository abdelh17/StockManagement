package com.abdel.stockmanagement.validators;

import com.abdel.stockmanagement.domain.dto.ClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ClientValidator {
    public static List<String> validate(ClientDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("Missing client last name");
            errors.add("Missing client first name");
            errors.add("Missing client email");
            errors.add("Missing client address");
            errors.add("Missing client birth date");
            return errors;
        }

        if(!StringUtils.hasLength(dto.getFName())){
            errors.add("Missing client first name");
        }
        if(!StringUtils.hasLength(dto.getLName())){
            errors.add("Missing client last name");
        }
        if(!StringUtils.hasLength(dto.getEmail())){
            errors.add("Missing client email");
        }
        if(!StringUtils.hasLength(dto.getPhoneNumber())){
            errors.add("Missing client phone number");
        }
        if(dto.getAddress()==null){
            errors.add("Missing client address");
        }else{
            if(dto.getAddress().getAddress1() == null)
                errors.add("The field address1 is mandatory");
            if(dto.getAddress().getCity() == null)
                errors.add("The field city is mandatory");
            if(dto.getAddress().getCountry() == null)
                errors.add("The field country is mandatory");
            if(dto.getAddress().getPostalCode() == null)
                errors.add("The field postalCode is mandatory");

        }        return errors;
    }
}
