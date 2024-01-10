package com.abdel.stockmanagement.controllers;

import com.abdel.stockmanagement.controllers.api.CategoryApi;
import com.abdel.stockmanagement.domain.dto.CategoryDto;
import com.abdel.stockmanagement.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController implements CategoryApi {
    private CategoryService service;

    @Autowired
    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @Override
    public CategoryDto save(CategoryDto dto) {
        return service.save(dto);
    }

    @Override
    public CategoryDto findById(Integer id) {
        return service.findById(id);
    }

    @Override
    public CategoryDto findByCode(String code) {
        return service.findByCode(code);
    }

    @Override
    public List<CategoryDto> findAll() {
        return service.findAll();
    }

    @Override
    public void delete(Integer id) {
        service.delete(id);
    }
}
