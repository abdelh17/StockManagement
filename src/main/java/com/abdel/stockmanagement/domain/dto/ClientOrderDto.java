package com.abdel.stockmanagement.domain.dto;

import com.abdel.stockmanagement.domain.entities.AbstractEntity;
import com.abdel.stockmanagement.domain.entities.Client;
import com.abdel.stockmanagement.domain.entities.ClientOrder;
import com.abdel.stockmanagement.domain.entities.LineOrderClient;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Builder
public class ClientOrderDto {
    private Integer id;

    private String code;
    private Date orderDate;

    private ClientDto client;

    private List<LineOrderClientDto> lineOrderClient;

}
