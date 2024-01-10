package com.abdel.stockmanagement.controllers.api;

import com.abdel.stockmanagement.domain.dto.CategoryDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import static com.abdel.stockmanagement.utils.Constants.APP_ROOT;

public interface CategoryApi {
    @PostMapping(value = APP_ROOT + "/categories/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto save(CategoryDto dto);

    @GetMapping(value = APP_ROOT + "/categories/{categoryId}", produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto findById(@PathVariable("categoryId") Integer id);

    @GetMapping(value = APP_ROOT + "/categories/{categoryCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto findByCode(@PathVariable("categoryCode") String code);

    @GetMapping(value = APP_ROOT + "/categories/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<CategoryDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/categories/delete/{categoryId}")
    void delete(@PathVariable("categoryId") Integer id);
}
