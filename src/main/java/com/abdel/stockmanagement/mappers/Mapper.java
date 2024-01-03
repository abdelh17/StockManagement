package com.abdel.stockmanagement.mappers;

public interface Mapper<ENTITY,DTO>{
    ENTITY toEntity(DTO dto);
    DTO fromEntity(ENTITY entity);

}