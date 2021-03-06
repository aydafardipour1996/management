package com.example.management.controller;

import com.example.management.dto.Category;
import com.example.management.dto.CategoryElement;
import com.example.management.dto.Employee;
import com.example.management.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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


    public void saveCat(Category category) {
        category.setName("role");
        try {
            employeeService.saveCat(category);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void saveCatElement(CategoryElement category_element) {
        Category category = employeeService.fetchByName("status");
        category_element.setCategory(category);
        category_element.setName("تایید شده");
        category_element.setCode("accepted");
        try {
            employeeService.saveElement(category_element);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void printCategoryElements(String name) {
        List<CategoryElement> category_elements = employeeService.findAllElements(name);
        for (CategoryElement category_element : category_elements) {
            System.out.println(category_element.getName());
        }
    }

    public String saveEmployee(Employee employee) {
        Employee mEmployee = employeeService.fetchEmployeeById(7L);
        CategoryElement category_element = employeeService.fetchByCode("Tester");
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

    public String updateEmployee(long id) {
        Employee employee = employeeService.fetchEmployeeById(id);
        CategoryElement category_element = employeeService.fetchByCode("Tester");
        employee.setName("فرزانه جلیلی");
        employee.setDayOff_limit(100);
        employee.setEmail("l.ayda@yahoo.com");
        employee.setRole(category_element);

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

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public ModelAndView showForm() {
        Employee employee = employeeService.fetchEmployeeById(15L);
        return new ModelAndView("employeeHome", "employee", employee);
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model) {
        //  saveCat(new Category());
        return "welcome";
    }


    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public String submit(@ModelAttribute("employee") Employee employee,
                         BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        model.addAttribute("name", employee.getName());
        model.addAttribute("email", employee.getEmail());
        model.addAttribute("id", employee.getId());
        return "employeeHome";
    }

}
