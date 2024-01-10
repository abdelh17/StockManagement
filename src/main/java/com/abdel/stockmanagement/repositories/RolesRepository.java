package com.abdel.stockmanagement.repositories;

import com.abdel.stockmanagement.domain.entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Integer, Roles> {
}
