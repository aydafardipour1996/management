package com.example.management;

import com.example.management.DTO.AskDayOff;
import com.example.management.DTO.Category;
import com.example.management.DTO.Category_element;
import com.example.management.DTO.Employee;
import com.example.management.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.List;

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

    public void saveAskDayOff(AskDayOff askDayOff) {
        Employee employee = employeeService.setEmployeeManager(5L);
        Date start= new Date(1595976019);
        Date end = new Date(1596667219);
        int deducted = ((1596667219-1595976019) / (1000*60*60*24));
        askDayOff.setEmployee(employee);
        askDayOff.setStart(start);
        askDayOff.setEnd(end);
        askDayOff.setDeducted(deducted);


        try {
            employeeService.saveDayOff(askDayOff);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void saveCat(Category category) {
        category.setName("status");
        try {
            employeeService.saveCat(category);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void saveCatElement(Category_element category_element) {
        Category category = employeeService.fetchByName("status");
        category_element.setCategory(category);
        category_element.setName("در انتظار مشاهده");
        category_element.setCode("waiting to be seen");
        try {
            employeeService.saveElement(category_element);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void printCategoryElements(String name) {
        List<Category_element> category_elements = employeeService.findAllElements(name);
        for (Category_element category_element:category_elements){
            System.out.println(category_element.getName());
        }
    }

    public String saveEmployee(Employee employee) {
        Employee mEmployee = employeeService.setEmployeeManager(1L);
        Category_element category_element = employeeService.fetchByCode("Tester");
        employee.setName("آیدا فردی پور");
        employee.setDayOff_limit(10);
        employee.setEmail("l.ayda@yahoo.com");
        employee.setRole(category_element);
        employee.setManager_id(mEmployee);
        try {
            employeeService.save(employee);
        } catch (Exception e) {
            e.printStackTrace();

            return "error";
        }
        return "start";
    }

/*    public String saveEmployee(String name, int limit, String email, long role, long manager) {
        Employee mEmployee = employeeService.setEmployeeManager(manager);
        Category_element element=
        Employee employee=new Employee();
        employee.setName(name);
        employee.setDayOff_limit(limit);
        employee.setEmail(email);
        employee.setRole(null);
        employee.setManager_id(mEmployee);
        try {
            employeeService.save(employee);
        } catch (Exception e) {
            e.printStackTrace();

            return "error";
        }
        return "start";
    }*/
}
