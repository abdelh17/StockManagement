package com.abdel.stockmanagement.controllers.api;

import com.abdel.stockmanagement.domain.dto.ClientDto;
import com.abdel.stockmanagement.domain.dto.CompanyDto;
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


public interface CompanyApi {
    @PostMapping(value = APP_ROOT + "/companies/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Save a comapany (edit or add)", response = CompanyDto.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "The company is created/modified"), @ApiResponse(code = 400, message = "The company is not valid")})
    CompanyDto save(CompanyDto dto);

    @GetMapping(value = APP_ROOT + "/companies/{companyId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Search for a company by ID", notes = "The ID is an integer", response = ClientDto.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "The company was found"), @ApiResponse(code = 404, message = "No company was found for the given ID")})
    CompanyDto findById(@PathVariable("companyId") Integer id);

    @GetMapping(value = APP_ROOT + "/companies/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Returns all companies", responseContainer = "List<CompanyDto>")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "A list of companies"),})
    List<CompanyDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/companies/delete/{companyId}")
    @ApiOperation(value = "Delete a company with ID", notes = "The ID is an integer", response = CompanyDto.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "The company was deleted"),})
    void delete(@PathVariable("companyId") Integer id);
}
