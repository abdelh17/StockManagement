package com.abdel.stockmanagement.services;

import com.abdel.stockmanagement.domain.dto.ArticleDto;
import com.abdel.stockmanagement.domain.dto.LineOrderClientDto;

import java.util.List;

public interface LineOrderClientService {
    LineOrderClientDto save(LineOrderClientDto dto);

    LineOrderClientDto findById(Integer id);

    LineOrderClientDto findByCode(String code);

    List<LineOrderClientDto> findAll();

    void delete(Integer id);

}
