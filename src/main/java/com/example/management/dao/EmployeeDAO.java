package com.example.management.dao;

import com.example.management.dto.Employee;
import com.example.management.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Component
public class EmployeeDAO implements IDao<Employee> {

    @Autowired
    EmployeeRepo employeeRepo;

    @Override
    public boolean save(Employee employee) throws Exception {
        // TODO Auto-generated method stub
        employeeRepo.save(employee);
        return false;
    }

    @Override
    public Optional<Employee> get(long id) {
        return Optional.empty();
    }

    @Override
    public Collection<Employee> getAll() {
        return null;
    }

    @Override
    public void update(Employee employee) {

    }

    @Override
    public void delete(Employee employee) {

    }

    @Override
    public Employee fetchById(long id) {
        return employeeRepo.findById(id).orElse(null);
    }

    @Override
    public Employee fetch(String s) {
        return null;
    }

    @Override
    public List<Employee> fetchAllByName(String name) {
        return null;
    }

    @Override
    public List<Employee> fetchAllById(long id) {
        return null;
    }

    @Override
    public List<Employee> fetchByEmployee(Employee employee) {
        return null;
    }


}
