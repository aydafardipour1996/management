package com.example.management.DAO;

import com.example.management.DTO.Employee;
import org.springframework.data.repository.CrudRepository;


public interface EmployeeRepo extends CrudRepository<Employee, Long> {

}

