package com.abdel.stockmanagement.repositories;

import com.abdel.stockmanagement.domain.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Integer, Company> {
}
