package com.abdel.stockmanagement.repositories;

import com.abdel.stockmanagement.domain.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Integer> {
    Optional<Sale> findSaleByCode(String code);
}
