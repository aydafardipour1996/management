package com.example.management.DTO;

import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;


    private long manager_id;

    private String name;


    private long role_id;


    private int dayOff_limit;


    private String email;

    public Employee(long manager_id, String name, long role_id, int dayOff_limit, String email) {
        this.manager_id = manager_id;
        this.name = name;
        this.role_id = role_id;
        this.dayOff_limit = dayOff_limit;
        this.email = email;
    }

    public Employee() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getManager_id() {
        return manager_id;
    }

    public void setManager_id(long manager_id) {
        this.manager_id = manager_id;
    }

    public long getRole_id() {
        return role_id;
    }

    public void setRole_id(long role_id) {
        this.role_id = role_id;
    }

    public int getDayOff_limit() {
        return dayOff_limit;
    }

    public void setDayOff_limit(int dayOff_limit) {
        this.dayOff_limit = dayOff_limit;
    }
}

