package com.abdel.stockmanagement.services.impl;

import com.abdel.stockmanagement.domain.dto.*;
import com.abdel.stockmanagement.domain.entities.*;
import com.abdel.stockmanagement.exceptions.EntityNotFoundException;
import com.abdel.stockmanagement.exceptions.ErrorCodes;
import com.abdel.stockmanagement.exceptions.InvalidEntityException;
import com.abdel.stockmanagement.mappers.Mapper;
import com.abdel.stockmanagement.repositories.*;
import com.abdel.stockmanagement.services.SaleService;
import com.abdel.stockmanagement.validators.ClientOrderValidator;
import com.abdel.stockmanagement.validators.SaleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Slf4j
public class SaleServiceImpl implements SaleService {

    private SaleRepository saleRepository;
    private ArticleRepository articleRepository;
    private LineSaleRepository lineSaleRepository;
    private Mapper<Sale, SaleDto> saleMapper;
    private Mapper<Article, ArticleDto> articleMapper;
    private Mapper<LineSale, LineSaleDto> lineSaleMapper;


    public SaleServiceImpl(SaleRepository saleRepository, ArticleRepository articleRepository, LineSaleRepository lineSaleRepository, Mapper<Sale, SaleDto> saleMapper, Mapper<Article, ArticleDto> articleMapper, Mapper<LineSale, LineSaleDto> lineSaleMapper) {
        this.saleRepository = saleRepository;
        this.articleRepository = articleRepository;
        this.lineSaleRepository = lineSaleRepository;
        this.saleMapper = saleMapper;
        this.articleMapper = articleMapper;
        this.lineSaleMapper = lineSaleMapper;
    }

    @Override
    public SaleDto save(SaleDto dto) {
        List<String> errors = SaleValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Sale is not valid");
            throw new InvalidEntityException("Invalid sale", ErrorCodes.SALE_NOT_VALID, errors);
        }

        List<String> articleErrors = new ArrayList<>();

        dto.getLinesSale().forEach(line -> {

            Optional<Article> article = articleRepository.findById(line.getArticle().getId());
            if (article.isEmpty()) {
                articleErrors.add("Sale with id: " + line.getSale().getId() + " does not exist.");
            }

        });

        if (!articleErrors.isEmpty()) {
            log.warn("");
            throw new InvalidEntityException("Article does not exist.", ErrorCodes.ARTICLE_NOT_FOUND, articleErrors);
        }

        Sale savedSale = saleRepository.save(saleMapper.toEntity(dto));


        dto.getLinesSale().forEach(line -> {
            LineSale lineSale = lineSaleMapper.toEntity(line);
            lineSale.setSale(savedSale);
            lineSaleRepository.save(lineSale);
        });


        return saleMapper.fromEntity(savedSale);

    }

    @Override
    public SaleDto findById(Integer id) {
        if (id == null) {
            log.error("Client order has null id");
            return null;
        }

        Optional<Sale> sale = saleRepository.findById(id);
        if (!sale.isPresent()) {
            throw new EntityNotFoundException("No sale found with id: " + id, ErrorCodes.SALE_NOT_FOUND);
        }
        return saleMapper.fromEntity(sale.get());
    }

    @Override
    public SaleDto findByCode(String code) {
        if (!StringUtils.hasLength(code)) {
            log.error("Sale has null code");
            return null;
        }
        Optional<Sale> sale = saleRepository.findSaleByCode(code);
        if (!sale.isPresent()) {
            throw new EntityNotFoundException("No client order found with code: " + code, ErrorCodes.CLIENT_ORDER_NOT_FOUND);
        }
        return saleMapper.fromEntity(sale.get());
    }

    @Override
    public List<SaleDto> findAll() {
        return StreamSupport.stream(saleRepository.findAll().spliterator(), false).map(saleMapper::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Sale has null id");
        }
        saleRepository.deleteById(id);

    }
}
