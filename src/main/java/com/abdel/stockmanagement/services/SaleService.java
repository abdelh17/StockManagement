package com.abdel.stockmanagement.services;

import com.abdel.stockmanagement.domain.dto.SaleDto;

import java.util.List;

public interface SaleService {
    SaleDto save(SaleDto dto);

    SaleDto findById(Integer id);

    SaleDto findByCode(String code);

    List<SaleDto> findAll();

    void delete(Integer id);
}
