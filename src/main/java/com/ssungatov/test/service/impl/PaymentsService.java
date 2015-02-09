package com.ssungatov.test.service.impl;

import com.ssungatov.test.entity.Employee;
import com.ssungatov.test.entity.Payments;
import com.ssungatov.test.filter.PaymentFilter;
import com.ssungatov.test.repository.PaymentsI;
import com.ssungatov.test.service.ServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentsService implements ServiceI<Payments> {

    @Autowired
    @Qualifier("paymentsDao")
    private PaymentsI paymentsDAO;

    @Override
    public List<Payments> findAll() {
        return paymentsDAO.findAll();
    }

    public List<Payments> findAll(PaymentFilter filter) {
        return (paymentsDAO).findAll(filter);
    }

    public List<Payments> findAll(Employee employee) {
        return (paymentsDAO).findAll(employee);
    }
    @Override
    public Payments findById(int id) {
        return paymentsDAO.findById(id);
    }

    @Override
    public Payments save(Payments entity) {
        return paymentsDAO.save(entity);
    }

    @Override
    public void delete(Payments entity) {
        paymentsDAO.delete(entity);
    }

    public void delete(Employee entity) {
        paymentsDAO.delete(entity);
    }
}
