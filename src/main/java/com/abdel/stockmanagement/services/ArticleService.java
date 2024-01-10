package com.abdel.stockmanagement.services;

import com.abdel.stockmanagement.domain.dto.ArticleDto;
import com.abdel.stockmanagement.domain.entities.Article;

import java.util.List;

public interface ArticleService {
    ArticleDto save(ArticleDto dto);

    ArticleDto findById(Integer id);

    ArticleDto findByArticleCode(String articleCode);

    List<ArticleDto> findAll();

    void delete(Integer id);
}
