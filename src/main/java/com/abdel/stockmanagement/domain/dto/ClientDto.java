package com.abdel.stockmanagement.domain.dto;

import com.abdel.stockmanagement.domain.entities.*;
import lombok.*;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Builder
public class ClientDto  {
    private Integer id;

    private String fName;
    private String lName;
    private AddressDto address;
    private String photo;
    private String email;
    private String phoneNumber;
    private Integer idCompany;
    private List<ClientOrderDto> clientOrders;






}
