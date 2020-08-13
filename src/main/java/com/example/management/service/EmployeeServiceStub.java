package com.example.management.service;

import com.example.management.DAO.IDao;
import com.example.management.DTO.Employee;

public class EmployeeServiceStub implements IEmployeeService {

    private IDao employeeDAO;

    @Override
    public Employee fetchById(long id) {
        Employee employee = new Employee();
        employee.setName("ayda");
        employee.setDayOff_limit(15);
        employee.setEmail("l.ayda@yahoo.com");
        employee.setRole(null);
        return employee;
    }

    @Override
    public boolean save(Employee employee) throws Exception {
        return employeeDAO.save(employee);
    }

    @Override
    public IDao getEmployeeDAO() {
        return employeeDAO;
    }

    @Override
    public void setEmployeeDAO(IDao employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public Employee setEmployeeManager(long id) {
        return null;
    }


}
