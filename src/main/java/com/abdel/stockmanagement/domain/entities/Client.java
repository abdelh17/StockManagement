package com.abdel.stockmanagement.domain.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Builder
@Entity
@Table(name="client")
public class Client extends AbstractEntity{
    private String fName;
    private String lName;
    @Embedded
    private Address address;
    private String photo;
    private String email;
    private String phoneNumber;
    private Integer idCompany;
    @OneToMany(mappedBy = "client")
    private List<ClientOrder> clientOrders;


}
