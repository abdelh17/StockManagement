package com.abdel.stockmanagement.controllers.api;

import com.abdel.stockmanagement.domain.dto.ClientDto;
import com.abdel.stockmanagement.domain.dto.CompanyDto;
import com.abdel.stockmanagement.domain.dto.SupplierDto;
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

@Api(APP_ROOT + "/suppliers")

public interface SupplierApi {
    @PostMapping(value = APP_ROOT + "/suppliers/create",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Save a supplier (edit or add)", response = CompanyDto.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "The supplier is created/modified"), @ApiResponse(code = 400, message = "The supplier is not valid")})
    SupplierDto save(SupplierDto dto);
    @GetMapping(value = APP_ROOT+"/suppliers/{supplierId}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Search for a supplier by ID", notes = "The ID is an integer", response = SupplierDto.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "The supplier was found"), @ApiResponse(code = 404, message = "No supplier was found for the given ID")})
    SupplierDto findById(@PathVariable("supplierId") Integer id);
    @GetMapping(value = APP_ROOT + "/suppliers/all",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Returns all suppliers", responseContainer = "List<SupplierDto>")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "A list of suppliers"),})
    List<SupplierDto> findAll();
    @DeleteMapping(value = APP_ROOT + "/suppliers/delete/{supplierId}")
    @ApiOperation(value = "Delete a supplier with ID", notes = "The ID is an integer", response = SupplierDto.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "The supplier was deleted"),})
    void delete(@PathVariable("supplierId") Integer id);
}
