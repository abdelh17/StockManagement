package com.abdel.stockmanagement.repositories;

import com.abdel.stockmanagement.domain.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Integer, Article> {
}
