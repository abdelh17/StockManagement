package com.abdel.stockmanagement.mappers.impl;

import com.abdel.stockmanagement.domain.dto.LineOrderSupplierDto;
import com.abdel.stockmanagement.domain.entities.Company;
import com.abdel.stockmanagement.domain.entities.LineOrderSupplier;
import com.abdel.stockmanagement.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
@Component
public class LineOrderSupplierMapperImpl implements Mapper<LineOrderSupplier, LineOrderSupplierDto> {
    private ModelMapper modelMapper;

    public LineOrderSupplierMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public LineOrderSupplier toEntity(LineOrderSupplierDto lineOrderSupplierDto) {
        return  modelMapper.map(lineOrderSupplierDto, LineOrderSupplier.class);
    }

    @Override
    public LineOrderSupplierDto fromEntity(LineOrderSupplier lineOrderSupplier) {
        return modelMapper.map(lineOrderSupplier, LineOrderSupplierDto.class);
    }
}
