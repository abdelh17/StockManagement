package com.abdel.stockmanagement.services.impl;

import com.abdel.stockmanagement.domain.dto.ArticleDto;
import com.abdel.stockmanagement.domain.dto.ClientDto;
import com.abdel.stockmanagement.domain.dto.ClientOrderDto;
import com.abdel.stockmanagement.domain.dto.LineOrderClientDto;
import com.abdel.stockmanagement.domain.entities.Article;
import com.abdel.stockmanagement.domain.entities.Client;
import com.abdel.stockmanagement.domain.entities.ClientOrder;
import com.abdel.stockmanagement.domain.entities.LineOrderClient;
import com.abdel.stockmanagement.exceptions.EntityNotFoundException;
import com.abdel.stockmanagement.exceptions.ErrorCodes;
import com.abdel.stockmanagement.exceptions.InvalidEntityException;
import com.abdel.stockmanagement.mappers.Mapper;
import com.abdel.stockmanagement.repositories.ArticleRepository;
import com.abdel.stockmanagement.repositories.ClientOrderRepository;
import com.abdel.stockmanagement.repositories.ClientRepository;
import com.abdel.stockmanagement.repositories.LineOrderClientRepository;
import com.abdel.stockmanagement.services.ClientOrderService;
import com.abdel.stockmanagement.validators.ClientOrderValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Slf4j
public class ClientOrderServiceImpl implements ClientOrderService {
    private ClientOrderRepository clientOrderRepository;
    private ArticleRepository articleRepository;
    private ClientRepository clientRepository;
    private LineOrderClientRepository lineOrderClientRepository;
    private Mapper<ClientOrder, ClientOrderDto> clientOrderMapper;
    private Mapper<Article, ArticleDto> articleMapper;
    private Mapper<Client, ClientDto> clientMapper;
    private Mapper<LineOrderClient, LineOrderClientDto> lineOrderClientMapper;

    @Autowired
    public ClientOrderServiceImpl(ClientOrderRepository clientOrderRepository, ArticleRepository articleRepository, ClientRepository clientRepository, LineOrderClientRepository lineOrderClientRepository, Mapper<ClientOrder, ClientOrderDto> clientOrderMapper, Mapper<Article, ArticleDto> articleMapper, Mapper<Client, ClientDto> clientMapper, Mapper<LineOrderClient, LineOrderClientDto> lineOrderClientMapper) {
        this.clientOrderRepository = clientOrderRepository;
        this.articleRepository = articleRepository;
        this.clientRepository = clientRepository;
        this.lineOrderClientRepository = lineOrderClientRepository;
        this.clientOrderMapper = clientOrderMapper;
        this.articleMapper = articleMapper;
        this.clientMapper = clientMapper;
        this.lineOrderClientMapper = lineOrderClientMapper;
    }

    @Override
    public ClientOrderDto save(ClientOrderDto dto) {
        List<String> errors = ClientOrderValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Client order is not valid");
            throw new InvalidEntityException("Invalid client order", ErrorCodes.CLIENT_ORDER_NOT_VALID, errors);
        }

        //Need to check that te client exists in the db
        Optional<Client> client = clientRepository.findById(dto.getClient().getId());
        if (client.isEmpty()) {
            log.warn("Client with id: " + dto.getClient().getId() + " was not found in the database");
            throw new EntityNotFoundException("Client with id: " + dto.getClient().getId() + " was not found in the database", ErrorCodes.CLIENT_NOT_FOUND);
        }
        List<String> articleErrors = new ArrayList<>();

        if (dto.getLineOrderClient() != null) {
            dto.getLineOrderClient().forEach(line -> {
                if (line.getArticle() != null) {
                    Optional<Article> article = articleRepository.findById(line.getArticle().getId());
                    if (article.isEmpty()) {
                        articleErrors.add("Article with id: " + line.getArticle().getId() + " does not exist.");
                    }
                }
            });
        }
        if (!articleErrors.isEmpty()) {
            log.warn("");
            throw new InvalidEntityException("Article does not exist.", ErrorCodes.ARTICLE_NOT_FOUND, articleErrors);
        }

        ClientOrder savedClientOrder = clientOrderRepository.save(clientOrderMapper.toEntity(dto));

        if (dto.getLineOrderClient() != null) {

            dto.getLineOrderClient().forEach(line -> {
                LineOrderClient lineOrderClient = lineOrderClientMapper.toEntity(line);
                lineOrderClient.setClientOrder(savedClientOrder);
                lineOrderClientRepository.save(lineOrderClient);
            });
        }

        return clientOrderMapper.fromEntity(savedClientOrder);

    }

    @Override
    public ClientOrderDto findById(Integer id) {
        if (id == null) {
            log.error("Client order has null id");
            return null;
        }

        Optional<ClientOrder> clientOrder = clientOrderRepository.findById(id);
        if (!clientOrder.isPresent()) {
            throw new EntityNotFoundException("No client order found with id: " + id, ErrorCodes.CLIENT_ORDER_NOT_FOUND);
        }
        return clientOrderMapper.fromEntity(clientOrder.get());
    }

    @Override
    public ClientOrderDto findByCode(String code) {
        if (!StringUtils.hasLength(code)) {
            log.error("Client order has null code");
            return null;
        }
        Optional<ClientOrder> clientOrder = clientOrderRepository.findClientOrderByCode(code);
        if (!clientOrder.isPresent()) {
            throw new EntityNotFoundException("No client order found with code: " + code, ErrorCodes.CLIENT_ORDER_NOT_FOUND);
        }
        return clientOrderMapper.fromEntity(clientOrder.get());
    }

    @Override
    public List<ClientOrderDto> findAll() {
        return StreamSupport.stream(clientOrderRepository.findAll().spliterator(), false).map(clientOrderMapper::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Client order has null id");
        }
        clientOrderRepository.deleteById(id);

    }
}
