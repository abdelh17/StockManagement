package com.abdel.stockmanagement.controllers.api;

import com.abdel.stockmanagement.domain.dto.SupplierDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import static com.abdel.stockmanagement.utils.Constants.APP_ROOT;


public interface SupplierApi {
    @PostMapping(value = APP_ROOT + "/suppliers/create",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    SupplierDto save(SupplierDto dto);
    @GetMapping(value = APP_ROOT+"/suppliers/{supplierId}",produces = MediaType.APPLICATION_JSON_VALUE)
    SupplierDto findById(@PathVariable("supplierId") Integer id);
    @GetMapping(value = APP_ROOT + "/suppliers/all",produces = MediaType.APPLICATION_JSON_VALUE)
    List<SupplierDto> findAll();
    @DeleteMapping(value = APP_ROOT + "/suppliers/delete/{supplierId}")
    void delete(@PathVariable("supplierId") Integer id);
}
