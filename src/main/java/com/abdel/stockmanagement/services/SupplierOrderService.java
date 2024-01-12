package com.abdel.stockmanagement.services;

import com.abdel.stockmanagement.domain.dto.SupplierOrderDto;

import java.util.List;

public interface SupplierOrderService {
    SupplierOrderDto save(SupplierOrderDto dto);

    SupplierOrderDto findById(Integer id);

    SupplierOrderDto findByCode(String code);

    List<SupplierOrderDto> findAll();

    void delete(Integer id);
}
