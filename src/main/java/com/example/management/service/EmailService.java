package com.example.management.service;

import com.example.management.dao.EmailDAO;
import com.example.management.dao.EmailLobDAO;
import com.example.management.dto.Email;
import com.example.management.dto.EmailLob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements IEmailService {

    @Autowired
    EmailDAO emailDAO;

    @Autowired
    EmailLobDAO emailLobDAO;

    @Override
    public void saveEmail(Email email) throws Exception {
        emailDAO.save(email);
    }

    @Override
    public void saveEmailLob(EmailLob emailLob) throws Exception {
        emailLobDAO.save(emailLob);
    }

}
