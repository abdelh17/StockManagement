package com.abdel.stockmanagement.controllers.api;

import com.abdel.stockmanagement.domain.dto.ClientDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import static com.abdel.stockmanagement.utils.Constants.APP_ROOT;


public interface ClientApi {
    @PostMapping(value = APP_ROOT + "/clients/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto save(ClientDto dto);

    @GetMapping(value = APP_ROOT + "/clients/{clientId}", produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto findById(@PathVariable("clientId") Integer id);

    @GetMapping(value = APP_ROOT + "/clients/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ClientDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/clients/delete/{clientId}")
    void delete(@PathVariable("clientId") Integer id);
}
