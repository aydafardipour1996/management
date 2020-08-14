package com.example.management.DAO;

import com.example.management.DTO.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Long> {
    Category findByName(String Name);
}
