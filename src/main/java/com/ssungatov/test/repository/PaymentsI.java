package com.ssungatov.test.repository;

import com.ssungatov.test.entity.Employee;
import com.ssungatov.test.entity.Payments;
import com.ssungatov.test.filter.PaymentFilter;

import java.util.List;

/**
 * Created by Regal on 10.01.14.
 */
public interface PaymentsI extends DAO<Payments> {
    public List<Payments> findAll(PaymentFilter filter);

    public List<Payments> findAll(Employee employee);

    public void delete(Employee employee);
}
