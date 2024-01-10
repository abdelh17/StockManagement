package com.abdel.stockmanagement.mappers.impl;

import com.abdel.stockmanagement.domain.dto.LineSaleDto;
import com.abdel.stockmanagement.domain.entities.LineSale;
import com.abdel.stockmanagement.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class LineSaleMapperImpl implements Mapper<LineSale, LineSaleDto> {
    private ModelMapper modelMapper;

    public LineSaleMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public LineSale toEntity(LineSaleDto lineSaleDto) {
        return modelMapper.map(lineSaleDto, LineSale.class);
    }

    @Override
    public LineSaleDto fromEntity(LineSale lineSale) {
        return modelMapper.map(lineSale, LineSaleDto.class);
    }
}
