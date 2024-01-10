package com.abdel.stockmanagement.mappers.impl;

import com.abdel.stockmanagement.domain.dto.SaleDto;
import com.abdel.stockmanagement.domain.entities.Sale;
import com.abdel.stockmanagement.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class SaleMapperImpl implements Mapper<Sale, SaleDto> {
    private ModelMapper modelMapper;

    public SaleMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public Sale toEntity(SaleDto saleDto) {
        return modelMapper.map(saleDto, Sale.class);
    }

    @Override
    public SaleDto fromEntity(Sale sale) {
        return modelMapper.map(sale, SaleDto.class);
    }
}
