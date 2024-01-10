package com.abdel.stockmanagement.services;

import com.abdel.stockmanagement.domain.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    CategoryDto save(CategoryDto dto);
    CategoryDto findById(Integer id);
    CategoryDto findByCode(String code);
    List<CategoryDto> findAll();
    void delete(Integer id);


}
