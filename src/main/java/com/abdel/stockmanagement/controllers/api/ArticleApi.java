package com.abdel.stockmanagement.controllers.api;

import com.abdel.stockmanagement.domain.dto.ArticleDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

import static com.abdel.stockmanagement.utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/articles")
public interface ArticleApi {
    @PostMapping(value = APP_ROOT + "/articles/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Save an article (edit or add)", response = ArticleDto.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "The article is created/modified"), @ApiResponse(code = 400, message = "The article is not valid")})
    ArticleDto save(@RequestBody ArticleDto dto);

    @GetMapping(value = APP_ROOT + "/articles/{articleId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Search for an article by ID", notes = "The ID is an integer", response = ArticleDto.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "The article was found"), @ApiResponse(code = 404, message = "No article was found for the given ID")})
    ArticleDto findById(@PathVariable("articleId") Integer id);

    @GetMapping(value = APP_ROOT + "/articles/{articleCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Search for an article by code", notes = "The code is a string", response = ArticleDto.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "The article was found"), @ApiResponse(code = 404, message = "No article was found for the given code")})
    ArticleDto findByArticleCode(@PathVariable("articleCode") String articleCode);

    @GetMapping(value = APP_ROOT + "/articles/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Returns all articles", responseContainer = "List<ArticleDto>")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "A list of articles"),})
    List<ArticleDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/articles/delete/{articleId}")
    @ApiOperation(value = "Delete an article with ID", notes = "The ID is an integer", response = ArticleDto.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "The article was deleted"),})
    void delete(@PathVariable("articleId") Integer id);
}
