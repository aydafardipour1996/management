package com.example.management.dao;

import com.example.management.dto.Category;
import com.example.management.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Component
public class CategoryDAO implements IDao<Category> {

    @Autowired
    CategoryRepo categoryRepo;

    @Override
    public boolean save(Category category) throws Exception {
        categoryRepo.save(category);
        return false;
    }

    @Override
    public Optional<Category> get(long id) {
        return Optional.empty();
    }

    @Override
    public Collection<Category> getAll() {
        return null;
    }

    @Override
    public void update(Category category) {

    }

    @Override
    public void delete(Category category) {

    }

    @Override
    public Category fetchById(long id) {
        return null;
    }

    @Override
    public List<Category> fetchAllByName(String name) {
        return null;
    }

    @Override
    public List<Category> fetchAllById(long id) {
        return null;
    }


    @Override
    public Category fetch(String name) {
        return categoryRepo.findByName(name);
    }
}
