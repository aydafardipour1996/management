package com.example.management.service;

import com.example.management.DAO.IDao;
import com.example.management.DTO.AskDayOff;
import com.example.management.DTO.Category;
import com.example.management.DTO.Category_element;
import com.example.management.DTO.Employee;

import java.util.List;

public interface IEmployeeService {

    Employee fetchById(long id);

    boolean save(Employee employee) throws Exception;

    boolean saveElement(Category_element category_element) throws Exception;

    boolean saveCat(Category category) throws Exception;

    boolean saveDayOff(AskDayOff askDayOff) throws Exception;

    IDao getEmployeeDAO();

    void setEmployeeDAO(IDao employeeDAO);

    Employee setEmployeeManager(long id);

    Category_element fetchByCode(String code);

    Category fetchByName(String name);

    List<Category_element> findAllElements(String name);


}

