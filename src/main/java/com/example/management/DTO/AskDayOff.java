package com.example.management.DTO;

import javax.persistence.*;
import java.util.Date;

@Entity
public class AskDayOff {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;

    @Basic
    @Temporal(TemporalType.TIME)
    private java.util.Date start;

    @Basic
    @Temporal(TemporalType.TIME)
    private java.util.Date end;

    @Transient
    private int deducted;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category_element status;

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

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public int getDeducted() {
        return deducted;
    }

    public void setDeducted(int deducted) {
        this.deducted = deducted;
    }

    public Category_element getStatus() {
        return status;
    }

    public void setStatus(Category_element status) {
        this.status = status;
    }
}
