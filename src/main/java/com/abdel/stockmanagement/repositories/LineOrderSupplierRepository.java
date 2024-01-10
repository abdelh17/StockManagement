package com.abdel.stockmanagement.repositories;

import com.abdel.stockmanagement.domain.entities.LineOrderClient;
import com.abdel.stockmanagement.domain.entities.LineOrderSupplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LineOrderSupplierRepository extends JpaRepository<Integer, LineOrderSupplier> {
}
