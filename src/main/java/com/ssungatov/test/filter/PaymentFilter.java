package com.ssungatov.test.filter;

import java.util.Date;

public class PaymentFilter {
    private boolean bonusActive = false;
    private int bonusBegin;
    private int bonusEnd;

    private boolean compenstationActive = false;
    private int compenstationBegin;
    private int compenstationEnd;

    private boolean salesActive = false;
    private int salesBegin;
    private int salesEnd;

    private boolean birthActive = false;
    private Date birthBegin;
    private Date birthEnd;


    public boolean isBonusActive() {
        return bonusActive;
    }

    public void setBonusActive(boolean bonusActive) {
        this.bonusActive = bonusActive;
    }

    public int getBonusBegin() {
        return bonusBegin;
    }

    public void setBonusBegin(int bonusBegin) {
        this.bonusBegin = bonusBegin;
    }

    public int getBonusEnd() {
        return bonusEnd;
    }

    public void setBonusEnd(int bonusEnd) {
        this.bonusEnd = bonusEnd;
    }

    public boolean isCompenstationActive() {
        return compenstationActive;
    }

    public void setCompenstationActive(boolean compenstationActive) {
        this.compenstationActive = compenstationActive;
    }

    public int getCompenstationBegin() {
        return compenstationBegin;
    }

    public void setCompenstationBegin(int compenstationBegin) {
        this.compenstationBegin = compenstationBegin;
    }

    public int getCompenstationEnd() {
        return compenstationEnd;
    }

    public void setCompenstationEnd(int compenstationEnd) {
        this.compenstationEnd = compenstationEnd;
    }

    public boolean isSalesActive() {
        return salesActive;
    }

    public void setSalesActive(boolean salesActive) {
        this.salesActive = salesActive;
    }

    public int getSalesBegin() {
        return salesBegin;
    }

    public void setSalesBegin(int salesBegin) {
        this.salesBegin = salesBegin;
    }

    public int getSalesEnd() {
        return salesEnd;
    }

    public void setSalesEnd(int salesEnd) {
        this.salesEnd = salesEnd;
    }

    public boolean isBirthActive() {
        return birthActive;
    }

    public void setBirthActive(boolean birthActive) {
        this.birthActive = birthActive;
    }

    public Date getBirthBegin() {
        return birthBegin;
    }

    public void setBirthBegin(Date birthBegin) {
        this.birthBegin = birthBegin;
    }

    public Date getBirthEnd() {
        return birthEnd;
    }

    public void setBirthEnd(Date birthEnd) {
        this.birthEnd = birthEnd;
    }
}
