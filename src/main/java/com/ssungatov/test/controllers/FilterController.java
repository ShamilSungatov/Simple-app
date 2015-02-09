package com.ssungatov.test.controllers;

import com.ssungatov.test.entity.Payments;
import com.ssungatov.test.filter.PaymentFilter;
import com.ssungatov.test.service.impl.PaymentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@Scope("session")
public class FilterController {
    private List<Payments> paymentsList;
    private PaymentFilter paymentFilter;

    @Autowired
    private PaymentsService paymentsService;

    @PostConstruct
    public void prepareView() {
        paymentFilter = new PaymentFilter();
        paymentsList = paymentsService.findAll();
    }

    public void useFilter() {
        paymentsList = paymentsService.findAll(paymentFilter);
    }


    public List<Payments> getPaymentsList() {
        return paymentsList;
    }

    public void setPaymentsList(List<Payments> paymentsList) {
        this.paymentsList = paymentsList;
    }

    public PaymentFilter getPaymentFilter() {
        return paymentFilter;
    }

    public void setPaymentFilter(PaymentFilter paymentFilter) {
        this.paymentFilter = paymentFilter;
    }
}
