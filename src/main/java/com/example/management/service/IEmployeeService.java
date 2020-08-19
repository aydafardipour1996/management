package com.example.management.service;

import com.example.management.dao.IDao;
import com.example.management.dto.AskDayOff;
import com.example.management.dto.Category;
import com.example.management.dto.CategoryElement;
import com.example.management.dto.Employee;

import java.util.List;
import java.util.Set;

public interface IEmployeeService {

    Employee fetchById(long id);

    boolean save(Employee employee) throws Exception;

    boolean saveElement(CategoryElement category_element) throws Exception;

    boolean saveCat(Category category) throws Exception;

    boolean saveDayOff(AskDayOff askDayOff) throws Exception;

    IDao getEmployeeDAO();

    void setEmployeeDAO(IDao employeeDAO);

    AskDayOff fetchAskDayOffById(long id);

    Employee fetchEmployeeById(long id);

    List<Employee> fetchAllEmployeesById(long id);

    CategoryElement fetchByCode(String code);

    Category fetchByName(String name);

    List<CategoryElement> findAllElements(String name);

    boolean checkManager(long manager_id, long subordinate);

    List<AskDayOff> fetchAllAskDayOff(long id);

    Set<Employee> addReceiver(long[] id);


}

