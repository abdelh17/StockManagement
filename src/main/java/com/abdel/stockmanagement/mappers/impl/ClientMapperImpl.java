package com.abdel.stockmanagement.mappers.impl;

import com.abdel.stockmanagement.domain.dto.ClientDto;
import com.abdel.stockmanagement.domain.entities.Client;
import com.abdel.stockmanagement.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ClientMapperImpl implements Mapper<Client, ClientDto> {
    private ModelMapper modelMapper;

    public ClientMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public Client toEntity(ClientDto clientDto) {
        return modelMapper.map(clientDto, Client.class);
    }

    @Override
    public ClientDto fromEntity(Client client) {
        return modelMapper.map(client, ClientDto.class);
    }
}
