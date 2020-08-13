package com.example.management.service;

import com.example.management.DAO.IDao;
import com.example.management.DAO.IEmployeeDAO;
import com.example.management.DTO.Employee;

public interface IEmployeeService {

    Employee fetchById(long id);

    boolean save(Employee employee) throws Exception;

    IDao getEmployeeDAO();

    void setEmployeeDAO(IDao employeeDAO);

    Employee setEmployeeManager(long id);
}

