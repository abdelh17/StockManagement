package com.abdel.stockmanagement.controllers;

import com.abdel.stockmanagement.controllers.api.UserApi;
import com.abdel.stockmanagement.domain.dto.UserDto;
import com.abdel.stockmanagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController implements UserApi {
    private UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @Override
    public UserDto save(UserDto dto) {
        return service.save(dto);
    }

    @Override
    public UserDto findById(Integer id) {
        return service.findById(id);
    }

    @Override
    public UserDto findByEmail(String email) {
        return service.findByEmail(email);
    }

    @Override
    public List<UserDto> findAll() {
        return service.findAll();
    }

    @Override
    public void delete(Integer id) {
        service.delete(id);
    }
}
