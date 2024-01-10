package com.abdel.stockmanagement.services.impl;

import com.abdel.stockmanagement.domain.dto.UserDto;
import com.abdel.stockmanagement.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Override
    public UserDto save(UserDto dto) {
        return null;
    }

    @Override
    public UserDto findById(Integer id) {
        return null;
    }

    @Override
    public UserDto findByEmail(String email) {
        return null;
    }

    @Override
    public List<UserDto> findAll() {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
