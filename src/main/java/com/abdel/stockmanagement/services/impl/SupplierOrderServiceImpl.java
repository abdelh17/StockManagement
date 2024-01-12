package com.abdel.stockmanagement.services.impl;

import com.abdel.stockmanagement.domain.dto.*;
import com.abdel.stockmanagement.domain.entities.*;
import com.abdel.stockmanagement.exceptions.EntityNotFoundException;
import com.abdel.stockmanagement.exceptions.ErrorCodes;
import com.abdel.stockmanagement.exceptions.InvalidEntityException;
import com.abdel.stockmanagement.mappers.Mapper;
import com.abdel.stockmanagement.repositories.*;
import com.abdel.stockmanagement.services.SupplierOrderService;
import com.abdel.stockmanagement.validators.SupplierOrderValidator;
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
public class SupplierOrderServiceImpl implements SupplierOrderService {
    private SupplierOrderRepository supplierOrderRepository;
    private ArticleRepository articleRepository;
    private SupplierRepository supplierRepository;
    private LineOrderSupplierRepository lineOrderSupplierRepository;
    private Mapper<SupplierOrder, SupplierOrderDto> supplierOrderMapper;
    private Mapper<LineOrderSupplier, LineOrderSupplierDto> lineOrderSupplierMapper;

    @Autowired
    public SupplierOrderServiceImpl(SupplierOrderRepository supplierOrderRepository,
                                    ArticleRepository articleRepository,
                                    SupplierRepository supplierRepository,
                                    LineOrderSupplierRepository lineOrderSupplierRepository,
                                    Mapper<SupplierOrder, SupplierOrderDto> supplierOrderMapper,
                                    Mapper<LineOrderSupplier, LineOrderSupplierDto> lineOrderSupplierMapper) {
        this.supplierOrderRepository = supplierOrderRepository;
        this.articleRepository = articleRepository;
        this.supplierRepository = supplierRepository;
        this.lineOrderSupplierRepository = lineOrderSupplierRepository;
        this.supplierOrderMapper = supplierOrderMapper;
        this.lineOrderSupplierMapper = lineOrderSupplierMapper;
    }


    @Override
    public SupplierOrderDto save(SupplierOrderDto dto) {
        List<String> errors = SupplierOrderValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Supplier order is not valid");
            throw new InvalidEntityException("Invalid supplier order", ErrorCodes.SUPPLIER_ORDER_NOT_VALID, errors);
        }

        //Need to check that the supplier exists in the db
        Optional<Supplier> supplier = supplierRepository.findById(dto.getSupplier().getId());
        if (supplier.isEmpty()) {
            log.warn("Supplier with id: " + dto.getSupplier().getId() + " was not found in the database");
            throw new EntityNotFoundException("Supplier with id: " + dto.getSupplier().getId() +
                    " was not found in the database", ErrorCodes.SUPPLIER_NOT_FOUND);
        }
        List<String> articleErrors = new ArrayList<>();

        if (dto.getLineOrderSupplier() != null) {
            dto.getLineOrderSupplier().forEach(line -> {
                if (line.getArticle() != null) {
                    Optional<Article> article = articleRepository.findById(line.getArticle().getId());
                    if (article.isEmpty()) {
                        articleErrors.add("Article with id: " + line.getArticle().getId() + " does not exist.");
                    }
                }
            });
        }
        if (!articleErrors.isEmpty()) {
            log.warn("");
            throw new InvalidEntityException("Article does not exist.", ErrorCodes.ARTICLE_NOT_FOUND, articleErrors);
        }

        SupplierOrder savedSupplierOrder = supplierOrderRepository.save(supplierOrderMapper.toEntity(dto));

        if (dto.getLineOrderSupplier() != null) {

            dto.getLineOrderSupplier().forEach(line -> {
                LineOrderSupplier lineOrderSupplier = lineOrderSupplierMapper.toEntity(line);
                lineOrderSupplier.setSupplierOrder(savedSupplierOrder);
                lineOrderSupplierRepository.save(lineOrderSupplier);
            });
        }

        return supplierOrderMapper.fromEntity(savedSupplierOrder);
    }

    @Override
    public SupplierOrderDto findById(Integer id) {
        if (id == null) {
            log.error("Supplier order has null id");
            return null;
        }

        Optional<SupplierOrder> supplierOrder = supplierOrderRepository.findById(id);
        if (supplierOrder.isEmpty()) {
            throw new EntityNotFoundException("No supplier order found with id: " + id, ErrorCodes.SUPPLIER_ORDER_NOT_FOUND);
        }
        return supplierOrderMapper.fromEntity(supplierOrder.get());
    }

    @Override
    public SupplierOrderDto findByCode(String code) {
        if (!StringUtils.hasLength(code)) {
            log.error("Supplier order has null code");
            return null;
        }
        Optional<SupplierOrder> supplierOrder = supplierOrderRepository.findSupplierOrderByCode(code);
        if (supplierOrder.isEmpty()) {
            throw new EntityNotFoundException("No supplier order found with code: " + code,
                    ErrorCodes.SUPPLIER_ORDER_NOT_FOUND);
        }
        return supplierOrderMapper.fromEntity(supplierOrder.get());
    }

    @Override
    public List<SupplierOrderDto> findAll() {
        return StreamSupport.stream(
                supplierOrderRepository.findAll().spliterator(), false)
                .map(supplierOrderMapper::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Supplier order has null id");
        }
        supplierOrderRepository.deleteById(id);
    }
}
