package com.abdel.stockmanagement.controllers.api;

import com.abdel.stockmanagement.domain.dto.UserDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import static com.abdel.stockmanagement.utils.Constants.APP_ROOT;


public interface UserApi {
    @PostMapping(value = APP_ROOT + "/users/create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    UserDto save(UserDto dto);

    @GetMapping(value = APP_ROOT + "/users/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    UserDto findById(@PathVariable("userId") Integer id);

    @GetMapping(value = APP_ROOT + "/users/{userEmail}", produces = MediaType.APPLICATION_JSON_VALUE)
    UserDto findByEmail(@PathVariable("userEmail") String email);

    @GetMapping(value = APP_ROOT + "/users/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<UserDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/users/delete/{userId}")
    void delete(@PathVariable("userId") Integer id);
}
