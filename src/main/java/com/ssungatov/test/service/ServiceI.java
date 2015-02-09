package com.ssungatov.test.service;


import java.util.List;

/**
 * Created by Shamil on 12.12.13.
 */
public interface ServiceI<T> {
    // Find all contacts
    public List<T> findAll();


    // Find a contact with details by id
    public T findById(int id);

    // Insert or update a contact
    public T save(T entity);

    // Delete a contact
    public void delete(T entity);
}
