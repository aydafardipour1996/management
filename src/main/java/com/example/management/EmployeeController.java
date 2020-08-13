package com.example.management;

import com.example.management.DTO.Employee;
import com.example.management.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;


    public String saveCEO(Employee employee) {
        employee.setName("مدیر عامل");
        employee.setDayOff_limit(150);
        employee.setEmail("l.ayda@yahoo.com");
        employee.setRole(null);
        employee.setManager_id(null);
        try {
            employeeService.save(employee);
        } catch (Exception e) {
            e.printStackTrace();

            return "error";
        }
        return "start";
    }

    public String saveEmployee(Employee employee) {
        Employee mEmployee = employeeService.setEmployeeManager(1L);
        employee.setName("ayda");
        employee.setDayOff_limit(15);
        employee.setEmail("l.ayda@yahoo.com");
        employee.setRole(null);
        employee.setManager_id(mEmployee);
        try {
            employeeService.save(employee);
        } catch (Exception e) {
            e.printStackTrace();

            return "error";
        }
        return "start";
    }
}
