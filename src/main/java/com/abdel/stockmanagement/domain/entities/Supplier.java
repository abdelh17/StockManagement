package com.abdel.stockmanagement.domain.entities;

import lombok.*;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name="supplier")
public class Supplier extends AbstractEntity{
    private String fName;
    private String lName;
    @Embedded
    private Address address;
    private String photo;
    private String email;
    private String phoneNumber;

    @OneToMany(mappedBy = "supplier")
    private List<SupplierOrder> supplierOrders;
}
