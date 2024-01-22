package com.abdel.stockmanagement.controllers;

import com.abdel.stockmanagement.controllers.api.SupplierOrderApi;
import com.abdel.stockmanagement.domain.dto.SupplierOrderDto;
import com.abdel.stockmanagement.services.SupplierOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SupplierOrderController implements SupplierOrderApi {
    private SupplierOrderService supplierOrderService;

    @Autowired
    public SupplierOrderController(SupplierOrderService supplierOrderService) {
        this.supplierOrderService = supplierOrderService;
    }

    @Override
    public SupplierOrderDto save(SupplierOrderDto dto) {
        return supplierOrderService.save(dto);
    }

    @Override
    public SupplierOrderDto findById(Integer id) {
        return supplierOrderService.findById(id);
    }

    @Override
    public SupplierOrderDto findByCode(String code) {
        return supplierOrderService.findByCode(code);
    }

    @Override
    public List<SupplierOrderDto> findAll() {
        return supplierOrderService.findAll();
    }

    @Override
    public void delete(Integer id) {
        supplierOrderService.delete(id);
    }
}
