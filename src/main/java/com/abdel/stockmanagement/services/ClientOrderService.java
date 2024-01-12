package com.abdel.stockmanagement.services;

import com.abdel.stockmanagement.domain.dto.ArticleDto;
import com.abdel.stockmanagement.domain.dto.ClientOrderDto;

import java.util.List;

public interface ClientOrderService {
    ClientOrderDto save(ClientOrderDto dto);

    ClientOrderDto findById(Integer id);

    ClientOrderDto findByCode(String code);

    List<ClientOrderDto> findAll();

    void delete(Integer id);
}
