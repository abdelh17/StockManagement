package com.abdel.stockmanagement.repositories;

import com.abdel.stockmanagement.domain.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Integer, Category> {
}
