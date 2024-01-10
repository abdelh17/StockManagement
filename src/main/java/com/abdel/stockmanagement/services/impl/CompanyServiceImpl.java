package com.abdel.stockmanagement.services.impl;

import com.abdel.stockmanagement.domain.dto.CompanyDto;
import com.abdel.stockmanagement.services.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CompanyServiceImpl implements CompanyService {
    @Override
    public CompanyDto save(CompanyDto dto) {
        return null;
    }

    @Override
    public CompanyDto findById(Integer id) {
        return null;
    }

    @Override
    public List<CompanyDto> findAll() {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
