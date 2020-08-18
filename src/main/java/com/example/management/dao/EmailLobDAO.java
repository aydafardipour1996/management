package com.example.management.dao;

import com.example.management.dto.Email;
import com.example.management.dto.EmailLob;
import com.example.management.repository.EmailLobRepo;
import com.example.management.repository.EmailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


@Component
public class EmailLobDAO implements IDao<EmailLob>{

    @Autowired
    EmailLobRepo emailLobRepo;

    @Override
    public boolean save(EmailLob emailLob) throws Exception {
        emailLobRepo.save(emailLob);
        return false;
    }

    @Override
    public Optional<EmailLob> get(long id) {
        return Optional.empty();
    }

    @Override
    public Collection<EmailLob> getAll() {
        return null;
    }

    @Override
    public void update(EmailLob emailLob) {

    }

    @Override
    public void delete(EmailLob emailLob) {

    }

    @Override
    public EmailLob fetchById(long id) {
        return null;
    }

    @Override
    public EmailLob fetch(String s) {
        return null;
    }

    @Override
    public List<EmailLob> fetchAllByName(String name) {
        return null;
    }

    @Override
    public List<EmailLob> fetchAllById(long id) {
        return null;
    }


}
