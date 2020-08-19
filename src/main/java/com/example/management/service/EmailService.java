package com.example.management.service;

import com.example.management.dao.EmailDAO;
import com.example.management.dao.EmailLobDAO;
import com.example.management.dao.EmployeeDAO;
import com.example.management.dto.Email;
import com.example.management.dto.EmailLob;
import com.example.management.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService implements IEmailService {

    @Autowired
    EmailDAO emailDAO;

    @Autowired
    EmailLobDAO emailLobDAO;

    @Autowired
    EmployeeDAO employeeDAO;

    @Override
    public void saveEmail(Email email) throws Exception {
        emailDAO.save(email);
    }

    @Override
    public void saveEmailLob(EmailLob emailLob) throws Exception {
        emailLobDAO.save(emailLob);
    }

    @Override
    public List<Email> fetchByReceiver(long id) {
        Employee employee = employeeDAO.fetchById(id);
        return emailDAO.fetchByEmployee(employee);
    }

    @Override
    public List<Email> fetchBySender(long id) {
        return emailDAO.fetchAllById(id);
    }

    @Override
    public void deleteEmail(Email email) throws Exception {
        emailDAO.delete(email);
    }

    @Override
    public void deleteEmailLob(EmailLob emailLob) throws Exception {
        emailLobDAO.delete(emailLob);
    }

    @Override
    public EmailLob fetchEmailLobById(long id) {
        return emailLobDAO.fetchById(id);
    }

    @Override
    public Email fetchEmailById(long id) {
        return emailDAO.fetchById(id);
    }

}
