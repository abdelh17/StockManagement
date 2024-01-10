package com.abdel.stockmanagement.repositories;

import com.abdel.stockmanagement.domain.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
}
