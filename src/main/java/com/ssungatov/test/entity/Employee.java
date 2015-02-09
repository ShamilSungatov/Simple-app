package com.ssungatov.test.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee extends BaseEntity {
    @Column
    private String name;
    @Column
    //true- male, false - female
    private boolean gender;

    @Temporal(TemporalType.DATE)
    private Date birth;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Payments> paymentsList;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public List<Payments> getPaymentsList() {
        return paymentsList;
    }

    public void setPaymentsList(List<Payments> paymentsList) {
        this.paymentsList = paymentsList;
    }
}
