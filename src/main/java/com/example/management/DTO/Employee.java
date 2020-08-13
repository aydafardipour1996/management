package com.example.management.DTO;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "manager_id")
    private Employee manager;

    @OneToMany(mappedBy = "manager")
    private Set<Employee> subordinates = new HashSet<>();

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category_element role;


    private int dayOff_limit;


    private String email;


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

    public Employee getManager_id() {
        return manager;
    }

    public void setManager_id(Employee manager) {
        this.manager = manager;
    }

    public Category_element getRole() {
        return role;
    }

    public void setRole(Category_element role) {
        this.role = role;
    }

    public int getDayOff_limit() {
        return dayOff_limit;
    }

    public void setDayOff_limit(int dayOff_limit) {
        this.dayOff_limit = dayOff_limit;
    }
}

