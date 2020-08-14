package com.example.management.DAO;

import com.example.management.DTO.Category_element;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CatElementRepo extends JpaRepository<Category_element, Long> {
    List<Category_element> findByCategory_Name(String category_name);
    Category_element findByCode(String code);
}
