package com.ssungatov.test.controllers;

import com.ssungatov.test.entity.Employee;
import com.ssungatov.test.service.ServiceI;
import com.ssungatov.test.utils.FacesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("session")
public class EmployeeController {
    private Employee employee;

    @Autowired
    private ServiceI<Employee> employeeService;

    public String newEmployee() {
        employee = new Employee();
        return "/user/employee";
    }

    public String editEmployee(Employee employee) {
        this.employee = employee;
        return "/user/employee";
    }

    public void save() {
        employeeService.save(employee);
        if (employee.getId() != null)
            FacesUtils.addFacesMessage("employee.save.success");
        employee = new Employee();

    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
