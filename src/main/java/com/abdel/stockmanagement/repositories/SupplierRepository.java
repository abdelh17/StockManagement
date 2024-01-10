package com.abdel.stockmanagement.repositories;

import com.abdel.stockmanagement.domain.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Integer, Supplier> {
}
