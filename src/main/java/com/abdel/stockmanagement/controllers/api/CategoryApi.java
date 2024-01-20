package com.abdel.stockmanagement.controllers.api;

import com.abdel.stockmanagement.domain.dto.ArticleDto;
import com.abdel.stockmanagement.domain.dto.CategoryDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.abdel.stockmanagement.utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/categories")
public interface CategoryApi {
    @PostMapping(value = APP_ROOT + "/categories/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Save a category (edit or add)", response = CategoryDto.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "The category is created/modified"), @ApiResponse(code = 400, message = "The category is not valid")})
    CategoryDto save(@RequestBody CategoryDto dto);

    @GetMapping(value = APP_ROOT + "/categories/id={categoryId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Search for a category by ID", notes = "The ID is an integer", response = CategoryDto.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "The category was found"), @ApiResponse(code = 404, message = "No category was found for the given ID")})
    CategoryDto findById(@PathVariable("categoryId") Integer id);

    @GetMapping(value = APP_ROOT + "/categories/code={categoryCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Search for a category by ID", notes = "The code is a String", response = CategoryDto.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "The category was found"), @ApiResponse(code = 404, message = "No category was found for the given code")})
    CategoryDto findByCode(@PathVariable("categoryCode") String code);

    @GetMapping(value = APP_ROOT + "/categories/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Returns all categories", responseContainer = "List<CategoryDto>")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "A list of categories"),})
    List<CategoryDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/categories/delete/{categoryId}")
    @ApiOperation(value = "Delete a category with ID", notes = "The ID is an integer", response = CategoryDto.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "The category was deleted"),})
    void delete(@PathVariable("categoryId") Integer id);
}
