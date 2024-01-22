package com.abdel.stockmanagement.controllers.api;

import com.abdel.stockmanagement.domain.dto.CategoryDto;
import com.abdel.stockmanagement.domain.dto.CompanyDto;
import com.abdel.stockmanagement.domain.dto.SupplierDto;
import com.abdel.stockmanagement.domain.dto.UserDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import static com.abdel.stockmanagement.utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/users")
public interface UserApi {
    @PostMapping(value = APP_ROOT + "/users/create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Save a user (edit or add)", response = UserDto.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "The user is created/modified"), @ApiResponse(code = 400, message = "The user is not valid")})
    UserDto save(UserDto dto);

    @GetMapping(value = APP_ROOT + "/users/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Search for a user by ID", notes = "The ID is an integer", response = UserDto.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "The user was found"), @ApiResponse(code = 404, message = "No user was found for the given ID")})
    UserDto findById(@PathVariable("userId") Integer id);

    @GetMapping(value = APP_ROOT + "/users/{userEmail}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Search for a user by email", response = UserDto.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "The user was found"), @ApiResponse(code = 404, message = "No user was found for the given email")})
    UserDto findByEmail(@PathVariable("userEmail") String email);

    @GetMapping(value = APP_ROOT + "/users/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Returns all users", responseContainer = "List<UserDto>")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "A list of users")})
    List<UserDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/users/delete/{userId}")
    @ApiOperation(value = "Delete a user with ID", notes = "The ID is an integer", response = UserDto.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "The user was deleted"),})
    void delete(@PathVariable("userId") Integer id);
}
