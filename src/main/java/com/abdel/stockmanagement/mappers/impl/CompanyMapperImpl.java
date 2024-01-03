package com.abdel.stockmanagement.mappers.impl;


import com.abdel.stockmanagement.domain.dto.CompanyDto;
import com.abdel.stockmanagement.domain.entities.Company;
import com.abdel.stockmanagement.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapperImpl implements Mapper<Company, CompanyDto> {
    private ModelMapper modelMapper;

    public CompanyMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public Company toEntity(CompanyDto companyDto) {
        return modelMapper.map(companyDto, Company.class);
    }

    @Override
    public CompanyDto fromEntity(Company company) {
        return modelMapper.map(company, CompanyDto.class);
    }
}
