package com.example.management.DAO;

import com.example.management.DTO.Category_element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Component
public class CatElementDAO implements IDao<Category_element> {

    @Autowired
    CatElementRepo catElementRepo;

    @Override
    public boolean save(Category_element category_element) throws Exception {
        catElementRepo.save(category_element);
        return false;
    }

    @Override
    public Optional<Category_element> get(long id) {
        return Optional.empty();
    }

    @Override
    public Collection<Category_element> getAll() {
        return null;
    }

    @Override
    public void update(Category_element category_element) {

    }

    @Override
    public void delete(Category_element category_element) {

    }

    @Override
    public Category_element fetchById(long id) {
        return null;
    }

    @Override
    public List<Category_element> fetchAllByName(String name) {
        return catElementRepo.findByCategory_Name(name);
    }


    @Override
    public Category_element fetch(String code) {
        return catElementRepo.findByCode(code);
    }


}
