package com.abdel.stockmanagement.domain.dto;

import com.abdel.stockmanagement.domain.entities.AbstractEntity;
import com.abdel.stockmanagement.domain.entities.Address;
import com.abdel.stockmanagement.domain.entities.SupplierOrder;
import lombok.*;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Builder
public class SupplierDto{
    private Integer id;

    private String fName;
    private String lName;
    private AddressDto address;
    private String photo;
    private String email;
    private String phoneNumber;
    private List<SupplierOrderDto> supplierOrders;
}
