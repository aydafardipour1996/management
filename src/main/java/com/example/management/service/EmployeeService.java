package com.example.management.service;

import com.example.management.dao.*;
import com.example.management.dto.AskDayOff;
import com.example.management.dto.Category;
import com.example.management.dto.CategoryElement;
import com.example.management.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
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
    public boolean saveElement(CategoryElement category_element) throws Exception {
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
    public AskDayOff fetchAskDayOffById(long id) {
        return askDayOffDAO.fetchById(id);
    }

    @Override
    public Employee fetchEmployeeById(long id) {
        return employeeDAO.fetchById(id);
    }

    @Override
    public List<Employee> fetchAllEmployeesById(long id) {
        return employeeDAO.fetchAllById(id);
    }

    @Override
    public CategoryElement fetchByCode(String code) {
        return catElementDAO.fetch(code);
    }

    @Override
    public Category fetchByName(String name) {
        return categoryDAO.fetch(name);
    }

    @Override
    public List<CategoryElement> findAllElements(String name) {
        return catElementDAO.fetchAllByName(name);
    }

    @Override
    public boolean checkManager(long manager_id, long subordinate_id) {
        Employee subordinate = employeeDAO.fetchById(subordinate_id);
        return manager_id == subordinate.getManager_id().getId();
    }

    @Override
    public List<AskDayOff> fetchAllAskDayOff(long id) {
        return askDayOffDAO.fetchAllById(id);
    }

    @Override
    public List<Employee> addReceiver(long[] id) {
        List<Employee> receivers = new ArrayList<>();
        for (long l : id) {
            receivers.add(fetchEmployeeById(l));
        }
        return receivers;
    }

    public void updateEmployeeLimit(long id, int deducted) throws Exception {
        Employee employee = employeeDAO.fetchById(id);
        employee.setDayOff_limit(employee.getDayOff_limit() - deducted);
        employeeDAO.save(employee);


    }

}
