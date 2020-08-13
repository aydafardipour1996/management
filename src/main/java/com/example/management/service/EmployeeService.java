package com.example.management.service;

import com.example.management.DAO.EmployeeDAO;
import com.example.management.DAO.IEmployeeDAO;
import com.example.management.DTO.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeService implements IEmployeeService {

    @Autowired
    EmployeeDAO employeeDAO;

    @Override
    public Employee fetchById(long id) {
        return null;
    }

    @Override
    public boolean save(Employee employee) throws Exception {
        employeeDAO.save(employee);
        return false;
    }

    @Override
    public IEmployeeDAO getEmployeeDAO() {
        return null;
    }

    @Override
    public void setEmployeeDAO(IEmployeeDAO employeeDAO) {

    }
}
