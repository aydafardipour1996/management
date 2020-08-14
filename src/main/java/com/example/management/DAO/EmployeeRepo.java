package com.example.management.DAO;

import com.example.management.DTO.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepo extends JpaRepository<Employee, Long> {


}

