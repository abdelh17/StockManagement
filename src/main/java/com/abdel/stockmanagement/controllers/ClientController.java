package com.abdel.stockmanagement.controllers;

import com.abdel.stockmanagement.controllers.api.ClientApi;
import com.abdel.stockmanagement.domain.dto.ClientDto;
import com.abdel.stockmanagement.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController implements ClientApi {
    private ClientService service;

    @Autowired
    public ClientController(ClientService service) {
        this.service = service;
    }

    @Override
    public ClientDto save(ClientDto dto) {
        return service.save(dto);
    }

    @Override
    public ClientDto findById(Integer id) {
        return service.findById(id);
    }

    @Override
    public List<ClientDto> findAll() {
        return service.findAll();
    }

    @Override
    public void delete(Integer id) {
        service.delete(id);
    }
}
