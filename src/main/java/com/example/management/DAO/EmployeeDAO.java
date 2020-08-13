package com.example.management.DAO;

import com.example.management.DTO.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
    public Employee setEmployeeManager(long id) {
      //  return new Employee();
        return employeeRepo.findById(id).orElse(null);
    }

}
