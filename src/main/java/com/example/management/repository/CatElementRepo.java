package com.example.management.repository;

import com.example.management.dto.CategoryElement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatElementRepo extends JpaRepository<CategoryElement, Long> {
    List<CategoryElement> findByCategory_Name(String category_name);
    CategoryElement findByCode(String code);
}
