package com.example.management.DAO;

import com.example.management.DTO.Employee;

public interface  IDao<T>{
    boolean save(T t) throws Exception;

    Employee setEmployeeManager(long id);
}