package com.example.management.service;

import com.example.management.dto.Email;
import com.example.management.dto.EmailLob;


public interface IEmailService {
     void saveEmail(Email email) throws Exception;
     void saveEmailLob(EmailLob emailLob) throws Exception;
}
