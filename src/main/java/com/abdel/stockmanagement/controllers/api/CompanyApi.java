package com.abdel.stockmanagement.controllers.api;

import com.abdel.stockmanagement.domain.dto.CompanyDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import static com.abdel.stockmanagement.utils.Constants.APP_ROOT;


public interface CompanyApi {
    @PostMapping(value = APP_ROOT + "/companies/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    CompanyDto save(CompanyDto dto);

    @GetMapping(value = APP_ROOT + "/companies/{companyId}", produces = MediaType.APPLICATION_JSON_VALUE)
    CompanyDto findById(@PathVariable("companyId") Integer id);

    @GetMapping(value = APP_ROOT + "/companies/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<CompanyDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/companies/delete/{companyId}")
    void delete(@PathVariable("companyId") Integer id);
}
