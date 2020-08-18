package com.example.management.dto;

import javax.persistence.*;

@Entity
public class AskDayOff {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;

    private String start;

    private String end;

    @Transient
    private int deducted;

    @ManyToOne(fetch = FetchType.LAZY)
    private CategoryElement status;

    public AskDayOff() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public int getDeducted() {
        return deducted;
    }

    public void setDeducted(int deducted) {
        this.deducted = deducted;
    }

    public CategoryElement getStatus() {
        return status;
    }

    public void setStatus(CategoryElement status) {
        this.status = status;
    }
}
