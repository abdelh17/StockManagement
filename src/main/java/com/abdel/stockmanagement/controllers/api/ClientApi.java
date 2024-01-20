package com.abdel.stockmanagement.controllers.api;

import com.abdel.stockmanagement.domain.dto.ArticleDto;
import com.abdel.stockmanagement.domain.dto.ClientDto;
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


@Api(APP_ROOT + "/clients")
public interface ClientApi {
    @PostMapping(value = APP_ROOT + "/clients/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Save a client (edit or add)", response = ClientDto.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "The client is created/modified"), @ApiResponse(code = 400, message = "The client is not valid")})
    ClientDto save(ClientDto dto);

    @GetMapping(value = APP_ROOT + "/clients/{clientId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Search for a client by ID", notes = "The ID is an integer", response = ClientDto.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "The client was found"), @ApiResponse(code = 404, message = "No client was found for the given ID")})
    ClientDto findById(@PathVariable("clientId") Integer id);

    @GetMapping(value = APP_ROOT + "/clients/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Returns all clients", responseContainer = "List<ClientDto>")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "A list of clients"),})
    List<ClientDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/clients/delete/{clientId}")
    @ApiOperation(value = "Delete a client with ID", notes = "The ID is an integer", response = ClientDto.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "The client was deleted"),})
    void delete(@PathVariable("clientId") Integer id);
}
