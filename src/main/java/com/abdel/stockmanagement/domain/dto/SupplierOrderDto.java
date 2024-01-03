package com.abdel.stockmanagement.domain.dto;

import com.abdel.stockmanagement.domain.entities.AbstractEntity;
import com.abdel.stockmanagement.domain.entities.LineOrderSupplier;
import com.abdel.stockmanagement.domain.entities.Supplier;
import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Data
@Builder
public class SupplierOrderDto{
    private Integer id;

    private String code;
    private SupplierDto supplier;
    private Instant orderDate;
    private List<LineOrderSupplierDto> lineordersupplier;


}
