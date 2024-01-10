package com.abdel.stockmanagement.repositories;

import com.abdel.stockmanagement.domain.entities.StockMovement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockMovementRepository extends JpaRepository<Integer, StockMovement> {
}
