package com.example.restaurant.repository;

import java.util.List;

public interface CrudRepository<T> {
    void save(T entity);
    T findById(int id);
    List<T> findAll();
    void delete(int id);
    int update(int id, T entity);
}