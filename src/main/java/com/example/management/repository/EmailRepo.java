package com.example.management.repository;

import com.example.management.dto.Email;
import com.example.management.dto.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailRepo extends JpaRepository<Email, Long> {
    List<Email> findByReceiverContaining(Employee employee);
    List<Email> findBySenderId(long id);
}
