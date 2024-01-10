package com.abdel.stockmanagement.controllers;

import com.abdel.stockmanagement.controllers.api.CompanyApi;
import com.abdel.stockmanagement.domain.dto.CompanyDto;
import com.abdel.stockmanagement.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CompanyController implements CompanyApi {
    private CompanyService service;

    @Autowired
    public CompanyController(CompanyService service) {
        this.service = service;
    }

    @Override
    public CompanyDto save(CompanyDto dto) {
        return service.save(dto);
    }

    @Override
    public CompanyDto findById(Integer id) {
        return service.findById(id);
    }

    @Override
    public List<CompanyDto> findAll() {
        return service.findAll();
    }

    @Override
    public void delete(Integer id) {
        service.delete(id);
    }
}
