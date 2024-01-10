package com.abdel.stockmanagement.repositories;

import com.abdel.stockmanagement.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Integer, User> {
}
