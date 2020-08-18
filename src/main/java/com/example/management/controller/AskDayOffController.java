package com.example.management.controller;

import com.example.management.dto.AskDayOff;
import com.example.management.dto.CategoryElement;
import com.example.management.dto.Employee;
import com.example.management.service.EmployeeService;
import com.example.management.utility.CheckUtil;
import com.example.management.utility.ShamsiDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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

    public void updateAskDayOffStatus(long askDayOffId, String code) {

        CategoryElement status = employeeService.fetchByCode(code);
        AskDayOff askDayOff = employeeService.fetchAskDayOffById(askDayOffId);
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

}
