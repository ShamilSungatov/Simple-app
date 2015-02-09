package com.ssungatov.test.repository.impl;

import com.ssungatov.test.entity.EntityI;
import org.springframework.transaction.annotation.Transactional;
import com.ssungatov.test.repository.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import java.util.List;


public class BaseDAOImpl<T extends EntityI> implements DAO<T> {
    protected Class<T> clazz;

    public BaseDAOImpl(Class<T> clazz) {
        this.clazz = clazz;
    }

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    protected EntityManager em;

    @Override
    @Transactional
    public T save(T entity) {
        if (entity.getId() == null) {
            em.persist(entity);
            em.flush();
        } else {
            em.merge(entity);

        }
        return entity;
    }

    @Override
    @Transactional
    public void delete(T entity) {
        em.remove(entity);
    }

    @Transactional
    public void delete(int id) {
        T entity = em.find(clazz, id);
        em.remove(entity);
    }

    @Override
    @Transactional
    public T findById(int id) {
        return em.find(clazz, id);
    }

    @Override
    public List<T> findAll() {
        Query query = em.createQuery("from " + clazz.getName());
        return query.getResultList();
    }


    public void setClazz(Class<T> clazz) {
        this.clazz = clazz;
    }
}
