package com.ssungatov.test.service.impl;

import com.ssungatov.test.entity.Employee;
import com.ssungatov.test.repository.DAO;
import com.ssungatov.test.service.ServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService implements ServiceI<Employee> {
    @Autowired
    @Qualifier("employeeDao")
    private DAO<Employee> employeeDAO;


    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeDAO.findById(id);
    }

    @Override
    public Employee save(Employee entity) {
        return employeeDAO.save(entity);
    }

    @Override
    @Transactional
    public void delete(Employee entity) {
        entity = employeeDAO.findById(entity.getId());
        employeeDAO.delete(entity);
    }
}
