package com.abdel.stockmanagement.domain.entities;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="user")
public class User extends AbstractEntity {
    private String fname;
    private String lname;
    private String email;
    private Instant birthDate;
    private String password;

    @Embedded
    private Address address;
    private String photo;
    @ManyToOne
    @JoinColumn(name= "idcompany")
    private Company company;

    @OneToMany(mappedBy = "user")
    private List<Roles> role;
}
