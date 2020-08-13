package com.example.management.service;

import com.example.management.DAO.EmployeeDAO;
import com.example.management.DAO.IDao;
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
    public IDao getEmployeeDAO() {
        return null;
    }

    @Override
    public void setEmployeeDAO(IDao employeeDAO) {

    }

    @Override
    public Employee setEmployeeManager(long id) {
        return employeeDAO.setEmployeeManager(id);
    }

}
