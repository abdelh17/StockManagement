package com.abdel.stockmanagement.repositories;

import com.abdel.stockmanagement.domain.entities.ClientOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientOrderRepository extends JpaRepository<ClientOrder, Integer> {
}
