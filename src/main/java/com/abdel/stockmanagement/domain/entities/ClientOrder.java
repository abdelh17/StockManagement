package com.abdel.stockmanagement.domain.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="clientorder")
public class ClientOrder extends AbstractEntity{
    private String code;
    private Date orderDate;
    @ManyToOne
    @JoinColumn(name="idclient")
    private Client client;

    @OneToMany(mappedBy = "clientOrder")
    private List<LineOrderClient> lineOrderClient;

}
