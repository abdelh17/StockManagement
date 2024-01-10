package com.abdel.stockmanagement.mappers.impl;

import com.abdel.stockmanagement.domain.dto.UserDto;
import com.abdel.stockmanagement.domain.entities.User;
import com.abdel.stockmanagement.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements Mapper<User, UserDto> {
    private ModelMapper modelMapper;

    public UserMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public User toEntity(UserDto userDto) {
        return modelMapper.map(userDto, User.class);
    }

    @Override
    public UserDto fromEntity(User user) {
        return modelMapper.map(user, UserDto.class);
    }
}
