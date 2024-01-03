package com.abdel.stockmanagement.mappers.impl;

import com.abdel.stockmanagement.domain.dto.ArticleDto;
import com.abdel.stockmanagement.domain.entities.Article;
import com.abdel.stockmanagement.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ArticleMapperImpl implements Mapper<Article, ArticleDto> {
    private ModelMapper modelMapper;

    public ArticleMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public Article toEntity(ArticleDto articleDto) {
        return modelMapper.map(articleDto, Article.class);
    }

    @Override
    public ArticleDto fromEntity(Article article) {
        return modelMapper.map(article, ArticleDto.class);
    }

}
