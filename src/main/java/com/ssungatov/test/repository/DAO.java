package com.ssungatov.test.repository;

import java.util.List;


public interface DAO<T> {
    T save(T entity);

    void delete(T entity);

    T findById(int id);

    List<T> findAll();
}
