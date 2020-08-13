package com.example.management.DAO;

import com.example.management.DTO.Employee;

public interface IEmployeeDAO {
    boolean save(Employee employee) throws Exception;
}
