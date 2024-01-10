package com.abdel.stockmanagement.services;

import com.abdel.stockmanagement.domain.dto.CategoryDto;
import com.abdel.stockmanagement.domain.dto.CompanyDto;

import java.util.List;

public interface CompanyService {
    CompanyDto save(CompanyDto dto);
    CompanyDto findById(Integer id);
    List<CompanyDto> findAll();
    void delete(Integer id);
}
