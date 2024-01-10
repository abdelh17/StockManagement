package com.abdel.stockmanagement.repositories;

import com.abdel.stockmanagement.domain.entities.LineOrderClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineOrderClientRepository extends JpaRepository<LineOrderClient, Integer> {
}
