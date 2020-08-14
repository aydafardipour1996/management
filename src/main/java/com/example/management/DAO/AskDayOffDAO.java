package com.example.management.DAO;

import com.example.management.DTO.AskDayOff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Component
public class AskDayOffDAO implements IDao<AskDayOff> {
    @Autowired
    DayOffRepo dayOffRepo;


    @Override
    public boolean save(AskDayOff askDayOff) throws Exception {
        dayOffRepo.save(askDayOff);
        return false;
    }

    @Override
    public Optional<AskDayOff> get(long id) {
        return Optional.empty();
    }

    @Override
    public Collection<AskDayOff> getAll() {
        return null;
    }

    @Override
    public void update(AskDayOff askDayOff) {

    }

    @Override
    public void delete(AskDayOff askDayOff) {

    }

    @Override
    public AskDayOff fetchById(long id) {
        return null;
    }

    @Override
    public AskDayOff fetch(String s) {
        return null;
    }

    @Override
    public List<AskDayOff> fetchAllByName(String name) {
        return null;
    }


/*    @Override
    public Employee setEmployeeManager(long id) {
        return null;
    }*/
}
