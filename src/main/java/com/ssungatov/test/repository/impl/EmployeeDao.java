package com.ssungatov.test.repository.impl;

import com.ssungatov.test.entity.Employee;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao extends BaseDAOImpl<Employee> {
    public EmployeeDao() {
        super(Employee.class);
    }


}
