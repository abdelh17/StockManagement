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
@EqualsAndHashCode(callSuper = true)
@Builder
@Entity
@Table(name="company")
public class Company extends AbstractEntity{
    private String name;

    private String description;

    @Embedded
    private Address address;

    private String fiscalCode;

    private String photo;

    private String email;

    private String phoneNumber;

    private String website;

    @OneToMany(mappedBy = "company")
    private List<User> users;
}
