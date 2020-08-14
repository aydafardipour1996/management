package com.example.management.service;

import com.example.management.DAO.*;
import com.example.management.DTO.AskDayOff;
import com.example.management.DTO.Category;
import com.example.management.DTO.Category_element;
import com.example.management.DTO.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeService implements IEmployeeService {

    @Autowired
    EmployeeDAO employeeDAO;

    @Autowired
    CategoryDAO categoryDAO;

    @Autowired
    CatElementDAO catElementDAO;

    @Autowired
    AskDayOffDAO askDayOffDAO;

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
    public boolean saveElement(Category_element category_element) throws Exception {
        catElementDAO.save(category_element);
        return false;
    }

    @Override
    public boolean saveCat(Category category) throws Exception {
        categoryDAO.save(category);
        return false;
    }

    @Override
    public boolean saveDayOff(AskDayOff askDayOff) throws Exception {
        askDayOffDAO.save(askDayOff);
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
        return employeeDAO.fetchById(id);
    }

    @Override
    public Category_element fetchByCode(String code) {
        return catElementDAO.fetch(code);
    }

    @Override
    public Category fetchByName(String name) {
        return categoryDAO.fetch(name);
    }

    @Override
    public List<Category_element> findAllElements(String name) {
        return catElementDAO.fetchAllByName(name);
    }


}
