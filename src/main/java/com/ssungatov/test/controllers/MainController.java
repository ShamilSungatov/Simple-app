package com.ssungatov.test.controllers;

import com.ssungatov.test.entity.Employee;
import com.ssungatov.test.service.ServiceI;
import com.ssungatov.test.service.impl.PaymentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.util.List;


@Controller
@Scope("session")

public class MainController {
    private int activeTab= 0;

    private List<Employee> employeeList;

    @Autowired
    ServiceI<Employee> employeeService;

    @Autowired
    PaymentsService paymentsService;

    @PostConstruct
    public void init() {
        employeeList = employeeService.findAll();

    }


    public String refresh() {
        employeeList = employeeService.findAll();
        return "/index";
    }

    public void delete(Employee employee) {
        paymentsService.delete(employee);
        employee.setPaymentsList(null);
        employeeService.delete(employee);
        refresh();
    }


    //------------------------------------------------
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public int getActiveTab() {
        return activeTab;
    }

    public void setActiveTab(int activeTab) {
        this.activeTab = activeTab;
    }
}
