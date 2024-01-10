package com.abdel.stockmanagement.services.impl;

import com.abdel.stockmanagement.domain.dto.ArticleDto;
import com.abdel.stockmanagement.domain.dto.CategoryDto;
import com.abdel.stockmanagement.domain.dto.ClientDto;
import com.abdel.stockmanagement.domain.entities.Article;
import com.abdel.stockmanagement.domain.entities.Category;
import com.abdel.stockmanagement.domain.entities.Client;
import com.abdel.stockmanagement.exceptions.EntityNotFoundException;
import com.abdel.stockmanagement.exceptions.ErrorCodes;
import com.abdel.stockmanagement.exceptions.InvalidEntityException;
import com.abdel.stockmanagement.mappers.Mapper;
import com.abdel.stockmanagement.repositories.ArticleRepository;
import com.abdel.stockmanagement.repositories.CategoryRepository;
import com.abdel.stockmanagement.services.CategoryService;
import com.abdel.stockmanagement.validators.ArticleValidator;
import com.abdel.stockmanagement.validators.CategoryValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository repository;
    private Mapper<Category, CategoryDto> mapper;

    @Autowired
    public CategoryServiceImpl(CategoryRepository repository, Mapper<Category, CategoryDto> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public CategoryDto save(CategoryDto dto) {
        List<String> errors = CategoryValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Category is not valid " + dto);
            throw new InvalidEntityException("Invalid category", ErrorCodes.CATEGORY_NOT_VALID, errors);
        }

        Category savedCategory = repository.save(mapper.toEntity(dto));

        return mapper.fromEntity(savedCategory);
    }

    @Override
    public CategoryDto findById(Integer id) {
        if (id == null) {
            log.error("Category id is null");
            return null;
        }
        Optional<Category> category = repository.findById(id);
        CategoryDto dto = mapper.fromEntity(category.get());
        return Optional.of(dto).orElseThrow(() ->
                new EntityNotFoundException("No category with id: " + id + " has been found.", ErrorCodes.CATEGORY_NOT_FOUND));
    }

    @Override
    public CategoryDto findByCode(String code) {
        if (code == null) {
            log.error("Article code is null");
            return null;
        }
        Optional<Category> category = repository.findCategoryByCode(code);
        CategoryDto dto = mapper.fromEntity(category.get());
        return Optional.of(dto).orElseThrow(() ->
                new EntityNotFoundException("No article with code: " + code + " has been found.", ErrorCodes.CATEGORY_NOT_FOUND));
    }

    @Override
    public List<CategoryDto> findAll() {
        return StreamSupport.stream(
                        repository.findAll().spliterator(), false)
                .map(mapper::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("category id is null");
        }
        repository.deleteById(id);
    }
}
