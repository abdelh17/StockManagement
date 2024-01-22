package com.abdel.stockmanagement.controllers;

import com.abdel.stockmanagement.controllers.api.ClientOrderApi;
import com.abdel.stockmanagement.domain.dto.ClientOrderDto;
import com.abdel.stockmanagement.services.ClientOrderService;
import com.abdel.stockmanagement.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientOrderController implements ClientOrderApi {
    private ClientOrderService clientOrderService;

    @Autowired
    public ClientOrderController(ClientOrderService clientOrderService) {
        this.clientOrderService = clientOrderService;
    }

    @Override
    public ResponseEntity<ClientOrderDto> save(ClientOrderDto dto) {

        return ResponseEntity.ok(clientOrderService.save(dto));
    }

    @Override
    public ResponseEntity<ClientOrderDto> findById(Integer id) {
        return ResponseEntity.ok(clientOrderService.findById(id));
    }

    @Override
    public ResponseEntity<ClientOrderDto> findByCode(String code) {
        return ResponseEntity.ok(clientOrderService.findByCode(code));
    }

    @Override
    public ResponseEntity<List<ClientOrderDto>> findAll() {
        return ResponseEntity.ok(clientOrderService.findAll());

    }
    @Override
    public ResponseEntity delete(Integer id) {
        clientOrderService.delete(id);
        return ResponseEntity.ok().build();
    }
}
