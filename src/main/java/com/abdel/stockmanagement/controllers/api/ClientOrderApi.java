package com.abdel.stockmanagement.controllers.api;

import com.abdel.stockmanagement.domain.dto.CategoryDto;
import com.abdel.stockmanagement.domain.dto.ClientOrderDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.abdel.stockmanagement.utils.Constants.APP_ROOT;


import java.util.List;

@Api(APP_ROOT + "/clientorders")
public interface ClientOrderApi {
    @PostMapping(APP_ROOT + "/clientorders/create")
    ResponseEntity<ClientOrderDto> save(@RequestBody ClientOrderDto dto);

    @GetMapping(APP_ROOT + "/clientorders/{id}")
    ResponseEntity<ClientOrderDto> findById(@PathVariable("id") Integer id);

    @GetMapping(APP_ROOT + "/clientorders/{code}")
    ResponseEntity<ClientOrderDto> findByCode(@PathVariable("code") String code);

    @GetMapping(APP_ROOT + "/clientorders/all")
    ResponseEntity<List<ClientOrderDto>> findAll();

    @DeleteMapping(APP_ROOT + "/clientorders/delete/{id}")
    ResponseEntity delete(@PathVariable("id") Integer id);
}
