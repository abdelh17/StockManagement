package com.abdel.stockmanagement.mappers.impl;

import com.abdel.stockmanagement.domain.dto.StockMovementDto;
import com.abdel.stockmanagement.domain.entities.StockMovement;
import com.abdel.stockmanagement.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class StockMovementMapperImpl implements Mapper<StockMovement, StockMovementDto> {
    private ModelMapper modelMapper;

    public StockMovementMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public StockMovement toEntity(StockMovementDto stockMovementDto) {
        return modelMapper.map(stockMovementDto, StockMovement.class);
    }

    @Override
    public StockMovementDto fromEntity(StockMovement stockMovement) {
        return modelMapper.map(stockMovement, StockMovementDto.class);
    }
}
