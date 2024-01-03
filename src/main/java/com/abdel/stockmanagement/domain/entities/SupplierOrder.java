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
@Table(name="supplierorder")
public class SupplierOrder extends AbstractEntity{
    private String code;

    @ManyToOne
    @JoinColumn(name = "idsupplier")
    private Supplier supplier;
    private Instant orderDate;

    @OneToMany(mappedBy = "supplierOrder" )
    private List<LineOrderSupplier> lineordersupplier;


}
