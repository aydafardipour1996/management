package com.example.management.controller;

import com.example.management.dto.AskDayOff;
import com.example.management.dto.CategoryElement;
import com.example.management.dto.Employee;
import com.example.management.service.EmployeeService;
import com.example.management.utility.CheckUtil;
import com.example.management.utility.ShamsiDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Objects;

@Controller
public class AskDayOffController {

    @Autowired
    EmployeeService employeeService;

    public boolean check(long employeeId, ShamsiDate start, ShamsiDate end) {
        CheckUtil checkUtil = new CheckUtil();
        boolean result = !checkUtil.DateIsAccurate(start, end);
        List<AskDayOff> askDayOffs = employeeService.fetchAllAskDayOff(employeeId);
        for (AskDayOff askDayOff : askDayOffs) {
            boolean a = checkUtil.checkForOverlap(new ShamsiDate(askDayOff.getStart()), new ShamsiDate(askDayOff.getEnd()), start, end);
            result = result || a;
            System.out.println(result);
        }


        System.out.println(result);
        return result;
    }

    public void saveAskDayOff(AskDayOff askDayOff) {
        Employee employee = employeeService.fetchEmployeeById(8L);

        askDayOff.setEmployee(employee);
        askDayOff.setStart("99/06/29");
        askDayOff.setEnd("99/08/03");

        if (!check(8L, new ShamsiDate("99/06/29"), new ShamsiDate("99/08/03"))) {

            try {
                employeeService.saveDayOff(askDayOff);
            } catch (Exception e) {
                e.printStackTrace();

            }
        }


    }

    public AskDayOff loadAskDayOff(long askDayOffId) {
        return employeeService.fetchAskDayOffById(askDayOffId);
    }

    public void updateAskDayOffStatus(long askDayOffId, String code) {

        CategoryElement status = employeeService.fetchByCode(code);
        AskDayOff askDayOff = loadAskDayOff(askDayOffId);
        CheckUtil checkUtil = new CheckUtil();
        int deducted = (int) checkUtil.deducted(new ShamsiDate(askDayOff.getStart()), new ShamsiDate(askDayOff.getEnd()));
        if (employeeService.checkManager(7, askDayOff.getEmployee().getId())) {
            askDayOff.setStatus(status);

            if (Objects.equals(code, "accepted")) {
                if (askDayOff.getEmployee().getDayOff_limit() < deducted) {
                    System.out.println("error");
                } else {
                    try {
                        employeeService.updateEmployeeLimit(askDayOff.getEmployee().getId(), deducted);
                        employeeService.saveDayOff(askDayOff);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @RequestMapping(value = "/updateStatus", method = RequestMethod.POST)
    public String update(@ModelAttribute("askDayOff") AskDayOff askDayOff,
                         BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        model.addAttribute("status", askDayOff.getStatus());
        updateAskDayOffStatus(askDayOff.getId(), "code");
        return "statusView";
    }

    @RequestMapping(value = "/DayOff", method = RequestMethod.GET)
    public ModelAndView showForm(long id) {
        AskDayOff askDayOff = loadAskDayOff(id);
        return new ModelAndView("askDayOffHome", "askDayOff", askDayOff);
    }

    @RequestMapping(value = "/updateStatus", method = RequestMethod.POST)
    public String submit(@ModelAttribute("askDayOff") AskDayOff askDayOff,
                         BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        model.addAttribute("employee_id", askDayOff.getEmployee().getId());
        model.addAttribute("start", askDayOff.getStart());
        model.addAttribute("end", askDayOff.getEnd());
        updateAskDayOffStatus(askDayOff.getId(), "code");
        return "statusView";
    }


}
