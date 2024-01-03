package com.abdel.stockmanagement.domain.dto;

import com.abdel.stockmanagement.domain.entities.Company;
import lombok.*;

import java.util.List;

@Data
@Builder
public class CompanyDto  {
    private Integer id;

    private String name;

    private String description;

    private AddressDto address;

    private String fiscalCode;

    private String photo;

    private String email;

    private String phoneNumber;

    private String website;


}
