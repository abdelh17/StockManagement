package com.abdel.stockmanagement.services;

import com.abdel.stockmanagement.domain.dto.CompanyDto;
import com.abdel.stockmanagement.domain.dto.SupplierDto;

import java.util.List;

public interface SupplierService {
    SupplierDto save(SupplierDto dto);
    SupplierDto findById(Integer id);
    List<SupplierDto> findAll();
    void delete(Integer id);
}
