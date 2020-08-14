package com.example.management.DAO;

import com.example.management.DTO.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepo extends JpaRepository<Email, Long> {
}
