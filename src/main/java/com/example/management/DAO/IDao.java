package com.example.management.DAO;

import com.example.management.DTO.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface  IDao<T>{
    boolean save(T t) throws Exception;
    Optional<T> get(long id);
    Collection<T> getAll();
    void update(T t);
    void delete(T t);
  //  Employee setEmployeeManager(long id);
    T fetchById(long id);
    T fetch(String s);
    List<T> fetchAllByName(String name);
/*    T fetchByCode(String code);
    T fetchByName(String name);*/
}