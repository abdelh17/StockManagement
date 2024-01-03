package com.abdel.stockmanagement.domain.dto;

import com.abdel.stockmanagement.domain.entities.AbstractEntity;
import com.abdel.stockmanagement.domain.entities.User;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Builder
public class RolesDto {
    private Integer id;

    private String roleName;
    private UserDto user;
}
