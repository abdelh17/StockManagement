package com.abdel.stockmanagement.repositories;

import com.abdel.stockmanagement.domain.entities.LineSale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineSaleRepository extends JpaRepository<LineSale, Integer> {
}
