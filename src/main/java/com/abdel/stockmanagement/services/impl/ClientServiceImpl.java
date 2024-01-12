package com.abdel.stockmanagement.services.impl;

import com.abdel.stockmanagement.domain.dto.ArticleDto;
import com.abdel.stockmanagement.domain.dto.ClientDto;
import com.abdel.stockmanagement.domain.entities.Article;
import com.abdel.stockmanagement.domain.entities.Client;
import com.abdel.stockmanagement.exceptions.EntityNotFoundException;
import com.abdel.stockmanagement.exceptions.ErrorCodes;
import com.abdel.stockmanagement.exceptions.InvalidEntityException;
import com.abdel.stockmanagement.mappers.Mapper;
import com.abdel.stockmanagement.repositories.ClientRepository;
import com.abdel.stockmanagement.services.ClientService;
import com.abdel.stockmanagement.validators.ArticleValidator;
import com.abdel.stockmanagement.validators.ClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService {

    private ClientRepository repository;
    private Mapper<Client, ClientDto> mapper;

    @Autowired
    public ClientServiceImpl(ClientRepository repository, Mapper<Client, ClientDto> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ClientDto save(ClientDto dto) {
        List<String> errors = ClientValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Client is not valid " + dto);
            throw new InvalidEntityException("Invalid client", ErrorCodes.CLIENT_NOT_VALID, errors);
        }

        Client savedClient = repository.save(mapper.toEntity(dto));

        return mapper.fromEntity(savedClient);
    }

    @Override
    public ClientDto findById(Integer id) {
        if (id == null) {
            log.error("Client id is null");
            return null;
        }
        Optional<Client> client = repository.findById(id);
        ClientDto dto = mapper.fromEntity(client.get());
        return Optional.of(dto).orElseThrow(() ->
                new EntityNotFoundException("No client with id: " + id + " has been found.", ErrorCodes.CLIENT_NOT_FOUND));
    }

    @Override
    public List<ClientDto> findAll() {
        return StreamSupport.stream(
                        repository.findAll().spliterator(), false)
                .map(mapper::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Client id is null");
        }
        repository.deleteById(id);
    }
}
