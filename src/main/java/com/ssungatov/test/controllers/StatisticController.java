package com.ssungatov.test.controllers;

import com.ssungatov.test.entity.Employee;
import com.ssungatov.test.entity.Payments;
import com.ssungatov.test.service.ServiceI;
import com.ssungatov.test.service.impl.PaymentsService;
import com.ssungatov.test.utils.FacesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.faces.model.SelectItem;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Controller
@Scope("session")
public class StatisticController {
    private Employee employee;

    private List<SelectItem> yearsList = new ArrayList<SelectItem>();

    private List<Payments> paymentsList;
    private Payments newPayment;

    @Autowired
    @Qualifier("paymentsService")
    private ServiceI<Payments> paymentsService;

    public StatisticController() {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 0; i < 10; i++) {
            yearsList.add(new SelectItem(year, String.valueOf(year--)));
        }


    }

    public String editPayments(Employee employee) {
        newPayment = new Payments();
        this.employee = employee;
        paymentsList = ((PaymentsService)paymentsService).findAll(employee);
        return "/user/statistic";
    }

    public void save() {
        newPayment.setEmployee(employee);
        paymentsService.save(newPayment);
        if (newPayment.getId() != null)
            FacesUtils.addFacesMessage("payment.save.success");
        if (paymentsList == null) {
            paymentsList = new ArrayList<Payments>();
        }
        paymentsList.add(newPayment);
        newPayment = new Payments();
    }

    public List<Payments> getPaymentsList() {
        return paymentsList;
    }

    public void setPaymentsList(List<Payments> paymentsList) {
        this.paymentsList = paymentsList;
    }

    public List<SelectItem> getYearsList() {
        return yearsList;
    }

    public void setYearsList(List<SelectItem> yearsList) {
        this.yearsList = yearsList;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


    public Payments getNewPayment() {
        return newPayment;
    }

    public void setNewPayment(Payments newPayment) {
        this.newPayment = newPayment;
    }
}
