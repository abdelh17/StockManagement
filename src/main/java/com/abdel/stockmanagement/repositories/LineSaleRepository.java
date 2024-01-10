package com.abdel.stockmanagement.repositories;

import com.abdel.stockmanagement.domain.entities.LineSale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LineSaleRepository extends JpaRepository<Integer, LineSale> {
}
