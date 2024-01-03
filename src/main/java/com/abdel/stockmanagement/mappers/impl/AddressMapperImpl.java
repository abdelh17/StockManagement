package com.abdel.stockmanagement.mappers.impl;

import com.abdel.stockmanagement.domain.dto.AddressDto;
import com.abdel.stockmanagement.domain.dto.ClientDto;
import com.abdel.stockmanagement.domain.entities.Address;
import com.abdel.stockmanagement.domain.entities.Client;
import com.abdel.stockmanagement.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AddressMapperImpl implements Mapper<Address, AddressDto> {
    private ModelMapper modelMapper;

    public AddressMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public Address toEntity(AddressDto addressDto) {
        return modelMapper.map(addressDto, Address.class);
    }

    @Override
    public AddressDto fromEntity(Address address) {
        return modelMapper.map(address, AddressDto.class);
    }
}
