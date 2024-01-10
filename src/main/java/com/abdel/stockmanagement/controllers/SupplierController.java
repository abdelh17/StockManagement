package com.abdel.stockmanagement.controllers;

import com.abdel.stockmanagement.controllers.api.SupplierApi;
import com.abdel.stockmanagement.domain.dto.SupplierDto;
import com.abdel.stockmanagement.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SupplierController implements SupplierApi {
    private SupplierService service;

    @Autowired
    public SupplierController(SupplierService service) {
        this.service = service;
    }

    @Override
    public SupplierDto save(SupplierDto dto) {
        return service.save(dto);
    }

    @Override
    public SupplierDto findById(Integer id) {
        return service.findById(id);
    }

    @Override
    public List<SupplierDto> findAll() {
        return service.findAll();
    }

    @Override
    public void delete(Integer id) {
        service.delete(id);
    }
}
