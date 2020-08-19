package com.example.management.controller;

import com.example.management.dto.Email;
import com.example.management.dto.EmailLob;
import com.example.management.dto.Employee;
import com.example.management.service.IEmailService;
import com.example.management.service.IEmployeeService;
import com.example.management.utility.CheckUtil;
import com.example.management.utility.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Set;

@Controller
public class EmailController {
    @Autowired
    IEmailService emailService;
    @Autowired
    IEmployeeService employeeService;


    public void saveEmail(Email email) {
        Employee sender = employeeService.fetchEmployeeById(8L);

        Set<Employee> receivers = employeeService.addReceiver(new long[]{7, 15});
        String date = CheckUtil.getCurrentDate();
        email.setDate("99/06/07");
        email.setHasAttachment(false);
        email.setSender(sender);
        email.setReceiver(receivers);
        email.setSubject("hello");
        email.setDate(date);
        EmailLob emailLob = new EmailLob();
        emailLob.setAttachment(FileUtil.loadBytes("night.png"));
        emailLob.setContent("i am currently very busy because im working on my ne project. thanks a lot");
        emailLob.setEmail(email);

        try {
            emailService.saveEmailLob(emailLob);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printEmails() {
        List<Email> emails = emailService.fetchBySender(8L);
        for (Email email : emails) {
            System.out.println(email.getId());
        }
    }

    public void deleteEmail(long id) {
        EmailLob emailLob = emailService.fetchEmailLobById(id);
        Email email = emailLob.getEmail();


        try {
            emailService.deleteEmailLob(emailLob);
            emailService.deleteEmail(email);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
