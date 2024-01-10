package com.abdel.stockmanagement.repositories;

import com.abdel.stockmanagement.domain.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Integer, Sale> {
}
