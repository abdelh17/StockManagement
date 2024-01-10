package com.abdel.stockmanagement.mappers.impl;

import com.abdel.stockmanagement.domain.dto.SupplierOrderDto;
import com.abdel.stockmanagement.domain.entities.SupplierOrder;
import com.abdel.stockmanagement.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class SupplierOrderMapperImpl implements Mapper<SupplierOrder, SupplierOrderDto> {
    private ModelMapper modelMapper;

    public SupplierOrderMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public SupplierOrder toEntity(SupplierOrderDto supplierOrderDto) {
        return modelMapper.map(supplierOrderDto, SupplierOrder.class);
    }

    @Override
    public SupplierOrderDto fromEntity(SupplierOrder supplierOrder) {
        return modelMapper.map(supplierOrder, SupplierOrderDto.class);
    }
}
