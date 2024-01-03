package com.abdel.stockmanagement.mappers.impl;

import com.abdel.stockmanagement.domain.dto.CategoryDto;
import com.abdel.stockmanagement.domain.entities.Category;
import com.abdel.stockmanagement.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapperImpl implements Mapper<Category, CategoryDto> {
    private ModelMapper modelMapper;

    public CategoryMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public Category toEntity(CategoryDto categoryDto) {
        return modelMapper.map(categoryDto, Category.class);
    }

    @Override
    public CategoryDto fromEntity(Category category) {
        return modelMapper.map(category, CategoryDto.class);
    }
}
