package com.example.management.service;

import com.example.management.dto.Email;
import com.example.management.dto.EmailLob;

import java.util.List;


public interface IEmailService {
     void saveEmail(Email email) throws Exception;
     void saveEmailLob(EmailLob emailLob) throws Exception;
     List<Email> fetchByReceiver(long id);
     List<Email> fetchBySender(long id);
     void deleteEmail(Email email) throws Exception;
     void deleteEmailLob(EmailLob emailLob) throws Exception;
     EmailLob fetchEmailLobById(long id);
     Email fetchEmailById(long id);

}
