package com.abdel.stockmanagement.services;

import com.abdel.stockmanagement.domain.dto.SupplierDto;
import com.abdel.stockmanagement.domain.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto save(UserDto dto);

    UserDto findById(Integer id);

    UserDto findByEmail(String email);

    List<UserDto> findAll();

    void delete(Integer id);
}
