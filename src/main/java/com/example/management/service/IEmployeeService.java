package com.example.management.service;

import com.example.management.DAO.IEmployeeDAO;
import com.example.management.DTO.Employee;

public interface IEmployeeService {

    Employee fetchById(long id);

    boolean save(Employee employee) throws Exception;

    IEmployeeDAO getEmployeeDAO();

    void setEmployeeDAO(IEmployeeDAO employeeDAO);

}

