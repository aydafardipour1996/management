package com.example.management.DTO;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Email {
    @ManyToMany
    @JoinTable(
            name = "receive ",
            joinColumns = @JoinColumn(name = "email_id"),
            inverseJoinColumns = @JoinColumn(name = "receiver"))
    Set<Employee> receiver;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee sender;
    private String subject;
    private boolean hasAttachment;

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date date;

    public Email() {
    }

    public Employee getSender() {
        return sender;
    }

    public void setSender(Employee sender) {
        this.sender = sender;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public boolean isHasAttachment() {
        return hasAttachment;
    }

    public void setHasAttachment(boolean hasAttachment) {
        this.hasAttachment = hasAttachment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
