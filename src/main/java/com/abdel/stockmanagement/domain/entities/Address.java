package com.abdel.stockmanagement.domain.entities;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class Address {
    private String address1;
    private String address2;
    private String city;
    private String postalCode;
    private String country;

}
