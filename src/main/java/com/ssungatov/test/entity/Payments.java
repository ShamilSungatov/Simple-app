package com.ssungatov.test.entity;

import javax.persistence.*;

@Entity
@Table(name = "payments")
public class Payments extends BaseEntity {
    @ManyToOne
    @PrimaryKeyJoinColumn
    private Employee employee;
    @Column
    private int year;
    @Column
    private int annualSalary;
    @Column
    private int annualBonus;
    @Column
    private int annualSales;


    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(int annualSalary) {
        this.annualSalary = annualSalary;
    }

    public int getAnnualBonus() {
        return annualBonus;
    }

    public void setAnnualBonus(int annualBonus) {
        this.annualBonus = annualBonus;
    }

    public int getAnnualSales() {
        return annualSales;
    }

    public void setAnnualSales(int annualSales) {
        this.annualSales = annualSales;
    }
}
