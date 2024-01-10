package com.abdel.stockmanagement.repositories;

import com.abdel.stockmanagement.domain.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Optional<Category> findCategoryByCode(String code);
}
