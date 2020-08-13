package com.example.management.DTO;

import javax.persistence.*;

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




}
