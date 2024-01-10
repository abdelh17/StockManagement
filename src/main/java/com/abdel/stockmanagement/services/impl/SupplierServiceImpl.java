package com.abdel.stockmanagement.services.impl;

import com.abdel.stockmanagement.domain.dto.SupplierDto;
import com.abdel.stockmanagement.services.SupplierService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SupplierServiceImpl implements SupplierService {
    @Override
    public SupplierDto save(SupplierDto dto) {
        return null;
    }

    @Override
    public SupplierDto findById(Integer id) {
        return null;
    }

    @Override
    public List<SupplierDto> findAll() {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
