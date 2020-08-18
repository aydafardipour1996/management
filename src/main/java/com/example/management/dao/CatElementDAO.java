package com.example.management.dao;

import com.example.management.dto.CategoryElement;
import com.example.management.repository.CatElementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Component
public class CatElementDAO implements IDao<CategoryElement> {

    @Autowired
    CatElementRepo catElementRepo;

    @Override
    public boolean save(CategoryElement category_element) throws Exception {
        catElementRepo.save(category_element);
        return false;
    }

    @Override
    public Optional<CategoryElement> get(long id) {
        return Optional.empty();
    }

    @Override
    public Collection<CategoryElement> getAll() {
        return null;
    }

    @Override
    public void update(CategoryElement category_element) {

    }

    @Override
    public void delete(CategoryElement category_element) {

    }

    @Override
    public CategoryElement fetchById(long id) {
        return null;
    }

    @Override
    public List<CategoryElement> fetchAllByName(String name) {
        return catElementRepo.findByCategory_Name(name);
    }

    @Override
    public List<CategoryElement> fetchAllById(long id) {
        return null;
    }


    @Override
    public CategoryElement fetch(String code) {
        return catElementRepo.findByCode(code);
    }


}
