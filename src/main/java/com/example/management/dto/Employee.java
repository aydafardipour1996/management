package com.example.management.dto;

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
    private CategoryElement role;

    @Column
    private int dayOff_limit;

    @Column(name = "email")
    private String email_address;

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
        return email_address;
    }

    public void setEmail(String email_address) {
        this.email_address = email_address;
    }

    public Employee getManager_id() {
        return manager;
    }

    public void setManager_id(Employee manager) {
        this.manager = manager;
    }

    public CategoryElement getRole() {
        return role;
    }

    public void setRole(CategoryElement role) {
        this.role = role;
    }

    public int getDayOff_limit() {
        return dayOff_limit;
    }

    public void setDayOff_limit(int dayOff_limit) {
        this.dayOff_limit = dayOff_limit;
    }
}

