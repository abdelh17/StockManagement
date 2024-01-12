package com.abdel.stockmanagement.domain.dto;

import lombok.*;

import java.time.Instant;
import java.util.List;

@Data
@Builder
public class SupplierOrderDto{
    private Integer id;
    private String code;
    private SupplierDto supplier;
    private Instant orderDate;
    private List<LineOrderSupplierDto> lineOrderSupplier;


}
