package com.abdel.stockmanagement.mappers.impl;

import com.abdel.stockmanagement.domain.dto.ClientOrderDto;
import com.abdel.stockmanagement.domain.entities.ClientOrder;
import com.abdel.stockmanagement.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ClientOrderMapperImpl implements Mapper<ClientOrder, ClientOrderDto> {

    private ModelMapper modelMapper;

    public ClientOrderMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public ClientOrder toEntity(ClientOrderDto clientOrderDto) {
        return modelMapper.map(clientOrderDto, ClientOrder.class);
    }

    @Override
    public ClientOrderDto fromEntity(ClientOrder clientOrder) {
        return modelMapper.map(clientOrder, ClientOrderDto.class);
    }
}
