package com.ssungatov.test.repository.impl;

import com.ssungatov.test.entity.Employee;
import com.ssungatov.test.entity.Payments;
import com.ssungatov.test.filter.PaymentFilter;
import com.ssungatov.test.repository.PaymentsI;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

@Repository
public class PaymentsDao extends BaseDAOImpl<Payments> implements PaymentsI {
    public PaymentsDao() {
        super(Payments.class);
    }

    @Transactional
    public List<Payments> findAll(PaymentFilter filter) {
        StringBuilder sql = new StringBuilder();
        sql.append("from Payments where 1=1 ");
        if (filter.isBonusActive()) {
            sql.append(" and :bonusBegin <= annualBonus and annualBonus <= :bonusEnd  ");
        }

        if (filter.isCompenstationActive()) {
            sql.append(" and :compenstationBegin <= (annualBonus + annualSalary) and ( annualBonus + annualSalary) <= :compenstationEnd  ");
        }

        if (filter.isSalesActive()) {
            sql.append(" and :salesBegin <= annualSales and annualSales <= :salesEnd  ");
        }

        if (filter.isBirthActive()) {
            sql.append(" and :birthBegin <= employee.birth and employee.birth <= :birthEnd  ");
        }


        Query query = em.createQuery(sql.toString());


        if (filter.isBonusActive()) {
            query.setParameter("bonusBegin", filter.getBonusBegin());
            query.setParameter("bonusEnd", filter.getBonusEnd());
        }

        if (filter.isCompenstationActive()) {
            query.setParameter("compenstationBegin", filter.getCompenstationBegin());
            query.setParameter("compenstationEnd", filter.getCompenstationEnd());
        }

        if (filter.isSalesActive()) {
            query.setParameter("salesBegin", filter.getSalesBegin());
            query.setParameter("salesEnd", filter.getSalesEnd());
        }

        if (filter.isBirthActive()) {
            query.setParameter("birthBegin", filter.getBirthBegin());
            query.setParameter("birthEnd", filter.getBirthEnd());
        }
        return query.getResultList();
    }


    @Override
    public List<Payments> findAll(Employee employee) {
        Query query = em.createQuery("from Payments p where p.employee.id = :id").setParameter("id", employee.getId());
        return  query.getResultList();
    }

    @Transactional
    public void delete(Employee employee) {
        Query query = em.createQuery("delete from Payments p where p.employee.id = :id").setParameter("id", employee.getId());
        query.executeUpdate();
    }
}
