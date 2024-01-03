package com.abdel.stockmanagement.domain.dto;

import com.abdel.stockmanagement.domain.entities.AbstractEntity;
import com.abdel.stockmanagement.domain.entities.Address;
import com.abdel.stockmanagement.domain.entities.Company;
import com.abdel.stockmanagement.domain.entities.Roles;
import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Data
@Builder
public class UserDto{
    private Integer id;
    private String fname;
    private String lname;
    private String email;
    private Instant birthDate;
    private String password;
    private AddressDto address;
    private String photo;
    private CompanyDto company;
    private List<RolesDto> role;
}
