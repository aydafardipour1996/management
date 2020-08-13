package com.example.management.service;

import com.example.management.DAO.IEmployeeDAO;
import com.example.management.DTO.Employee;

public class EmployeeServiceStub implements IEmployeeService {

    private IEmployeeDAO employeeDAO;

    @Override
    public Employee fetchById(long id) {
        Employee employee=new Employee();
        employee.setManager_id(30);
        employee.setName("ayda");
        employee.setDayOff_limit(15);
        employee.setEmail("l.ayda@yahoo.com");
        employee.setRole_id(10);
        return employee;
    }

    @Override
    public boolean save(Employee employee) throws Exception {
        return employeeDAO.save(employee);
    }

    @Override
    public IEmployeeDAO getEmployeeDAO() {
        return employeeDAO;
    }

    @Override
    public void setEmployeeDAO(IEmployeeDAO employeeDAO) {
this.employeeDAO=employeeDAO;
    }
}
