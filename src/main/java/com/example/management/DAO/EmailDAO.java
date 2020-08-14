package com.example.management.DAO;

import com.example.management.DTO.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


@Component
public class EmailDAO implements IDao<Email>{

    @Autowired
    EmailRepo emailRepo;

    @Override
    public boolean save(Email email) throws Exception {
        emailRepo.save(email);
        return false;
    }

    @Override
    public Optional<Email> get(long id) {
        return Optional.empty();
    }

    @Override
    public Collection<Email> getAll() {
        return null;
    }

    @Override
    public void update(Email email) {

    }

    @Override
    public void delete(Email email) {

    }

    @Override
    public Email fetchById(long id) {
        return null;
    }

    @Override
    public Email fetch(String s) {
        return null;
    }

    @Override
    public List<Email> fetchAllByName(String name) {
        return null;
    }




}
