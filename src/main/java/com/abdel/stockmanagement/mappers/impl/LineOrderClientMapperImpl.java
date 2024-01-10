package com.abdel.stockmanagement.mappers.impl;

import com.abdel.stockmanagement.domain.dto.CompanyDto;
import com.abdel.stockmanagement.domain.dto.LineOrderClientDto;
import com.abdel.stockmanagement.domain.entities.Company;
import com.abdel.stockmanagement.domain.entities.LineOrderClient;
import com.abdel.stockmanagement.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class LineOrderClientMapperImpl implements Mapper<LineOrderClient, LineOrderClientDto> {
    private ModelMapper modelMapper;

    public LineOrderClientMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public LineOrderClient toEntity(LineOrderClientDto dto) {
        return modelMapper.map(dto, LineOrderClient.class);
    }

    @Override
    public LineOrderClientDto fromEntity(LineOrderClient entity) {
        return modelMapper.map(entity, LineOrderClientDto.class);
    }
}
