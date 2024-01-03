package com.abdel.stockmanagement.domain.dto;

import com.abdel.stockmanagement.domain.entities.Address;
import lombok.*;

import javax.persistence.Embeddable;

@Data
@Builder
public class AddressDto {
    private String address1;
    private String address2;
    private String city;
    private String postalCode;
    private String country;

}
