package com.abdel.stockmanagement.mappers.impl;

import com.abdel.stockmanagement.domain.dto.RolesDto;
import com.abdel.stockmanagement.domain.entities.Roles;
import com.abdel.stockmanagement.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class RolesMapperImpl implements Mapper<Roles, RolesDto> {
    private ModelMapper modelMapper;

    public RolesMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public Roles toEntity(RolesDto rolesDto) {
        return modelMapper.map(rolesDto, Roles.class);
    }

    @Override
    public RolesDto fromEntity(Roles roles) {
        return modelMapper.map(roles, RolesDto.class);
    }
}
