package com.abdel.stockmanagement.services.impl;

import com.abdel.stockmanagement.domain.dto.ArticleDto;
import com.abdel.stockmanagement.domain.entities.Article;
import com.abdel.stockmanagement.exceptions.EntityNotFoundException;
import com.abdel.stockmanagement.exceptions.ErrorCodes;
import com.abdel.stockmanagement.exceptions.InvalidEntityException;
import com.abdel.stockmanagement.mappers.Mapper;
import com.abdel.stockmanagement.mappers.impl.ArticleMapperImpl;
import com.abdel.stockmanagement.repositories.ArticleRepository;
import com.abdel.stockmanagement.services.ArticleService;
import com.abdel.stockmanagement.validators.ArticleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {
    private ArticleRepository articleRepository;
    private Mapper<Article, ArticleDto> articleMapper;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository, Mapper<Article, ArticleDto> articleMapper) {
        this.articleRepository = articleRepository;
        this.articleMapper = articleMapper;
    }

    @Override
    public ArticleDto save(ArticleDto dto) {
        List<String> errors = ArticleValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Article is not valid " + dto);
            throw new InvalidEntityException("Invalid article", ErrorCodes.ARTICLE_NOT_VALID, errors);
        }

        Article savedArticle = articleRepository.save(articleMapper.toEntity(dto));

        return articleMapper.fromEntity(savedArticle);
    }

    @Override
    public ArticleDto findById(Integer id) {
        if (id == null) {
            log.error("Article id is null");
            return null;
        }
        Optional<Article> article = articleRepository.findById(id);
        ArticleDto dto = articleMapper.fromEntity(article.get());
        return Optional.of(dto).orElseThrow(() ->
                new EntityNotFoundException("No article with code: " + id + " has been found.", ErrorCodes.ARTICLE_NOT_FOUND));

    }

    @Override
    public ArticleDto findByArticleCode(String articleCode) {
        if (articleCode == null) {
            log.error("Article code is null");
            return null;
        }
        Optional<Article> article = articleRepository.findArticleByArticleCode(articleCode);
        ArticleDto dto = articleMapper.fromEntity(article.get());
        return Optional.of(dto).orElseThrow(() ->
                new EntityNotFoundException("No article with code: " + articleCode + " has been found.", ErrorCodes.ARTICLE_NOT_FOUND));

    }

    @Override
    public List<ArticleDto> findAll() {
        return StreamSupport.stream(
                        articleRepository.findAll().spliterator(), false)
                .map(articleMapper::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Article id is null");
        }
        articleRepository.deleteById(id);
    }
}
