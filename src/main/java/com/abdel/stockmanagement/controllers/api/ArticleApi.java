package com.abdel.stockmanagement.controllers.api;

import com.abdel.stockmanagement.domain.dto.ArticleDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

import static com.abdel.stockmanagement.utils.Constants.APP_ROOT;

public interface ArticleApi {
    @PostMapping(value = APP_ROOT + "/articles/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto save(@RequestBody ArticleDto dto);

    @GetMapping(value = APP_ROOT + "/articles/{articleId}", produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto findById(@PathVariable("articleId") Integer id);

    @GetMapping(value = APP_ROOT + "/articles/{articleCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto findByArticleCode(@PathVariable("articleCode") String articleCode);

    @GetMapping(value = APP_ROOT + "/articles/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ArticleDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/articles/delete/{articleId}")
    void delete(@PathVariable("articleId") Integer id);
}
