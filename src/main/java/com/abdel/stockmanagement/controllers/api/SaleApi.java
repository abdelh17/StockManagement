package com.abdel.stockmanagement.controllers.api;

import com.abdel.stockmanagement.domain.dto.SaleDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import static com.abdel.stockmanagement.utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/sales")
public interface SaleApi {
    @PostMapping(APP_ROOT + "/sales/create")
    SaleDto save(SaleDto dto);

    @GetMapping(APP_ROOT + "/sales/{id}")
    SaleDto findById(@PathVariable Integer id);

    @GetMapping(APP_ROOT + "/sales/{code}")
    SaleDto findByCode(@PathVariable String code);

    @GetMapping(APP_ROOT + "/sales/all")
    List<SaleDto> findAll();

    @DeleteMapping(APP_ROOT + "/sales/delete/{id}")
    void delete(@PathVariable Integer id);
}
