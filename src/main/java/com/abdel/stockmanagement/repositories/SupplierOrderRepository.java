package com.abdel.stockmanagement.repositories;

import com.abdel.stockmanagement.domain.entities.SupplierOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SupplierOrderRepository extends JpaRepository<SupplierOrder, Integer> {
    Optional<SupplierOrder> findSupplierOrderByCode(String code);
}
