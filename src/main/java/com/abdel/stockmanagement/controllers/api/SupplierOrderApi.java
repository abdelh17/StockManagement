package com.abdel.stockmanagement.controllers.api;

import com.abdel.stockmanagement.domain.dto.SupplierOrderDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.abdel.stockmanagement.utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/supplierorders")

public interface SupplierOrderApi {

    @PostMapping(APP_ROOT + "/supplierorders/create")
    SupplierOrderDto save(@RequestBody SupplierOrderDto dto);

    @GetMapping(APP_ROOT + "/supplierorders/{id}")
    SupplierOrderDto findById(@PathVariable("id") Integer id);

    @GetMapping(APP_ROOT + "/supplierorders/{code}")
    SupplierOrderDto findByCode(@PathVariable("code") String code);

    @GetMapping(APP_ROOT + "/supplierorders/all")
    List<SupplierOrderDto> findAll();

    @DeleteMapping(APP_ROOT + "/supplierorders/delete/{id}")
    void delete(@PathVariable("id") Integer id);
}
