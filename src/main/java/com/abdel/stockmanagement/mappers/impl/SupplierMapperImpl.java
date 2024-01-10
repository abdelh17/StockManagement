package com.abdel.stockmanagement.mappers.impl;

import com.abdel.stockmanagement.domain.dto.SupplierDto;
import com.abdel.stockmanagement.domain.entities.Supplier;
import com.abdel.stockmanagement.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class SupplierMapperImpl implements Mapper<Supplier, SupplierDto> {
    private ModelMapper modelMapper;

    public SupplierMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public Supplier toEntity(SupplierDto supplierDto) {
        return modelMapper.map(supplierDto, Supplier.class);
    }

    @Override
    public SupplierDto fromEntity(Supplier supplier) {
        return modelMapper.map(supplier, SupplierDto.class);
    }
}
