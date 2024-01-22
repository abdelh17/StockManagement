package com.abdel.stockmanagement.controllers;

import com.abdel.stockmanagement.controllers.api.SaleApi;
import com.abdel.stockmanagement.domain.dto.SaleDto;
import com.abdel.stockmanagement.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SaleController implements SaleApi {
    private SaleService saleService;

    @Autowired
    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }


    @Override
    public SaleDto save(SaleDto dto) {
        return saleService.save(dto);
    }

    @Override
    public SaleDto findById(Integer id) {
        return saleService.findById(id);
    }

    @Override
    public SaleDto findByCode(String code) {
        return saleService.findByCode(code);
    }

    @Override
    public List<SaleDto> findAll() {
        return saleService.findAll();
    }

    @Override
    public void delete(Integer id) {
        saleService.delete(id);
    }
}
