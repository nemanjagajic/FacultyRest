package com.nemanjagajic.dao;

import java.util.List;

public interface BasicDAO<T> {
    List<T> getAll();
    T getById(Integer id);
    T create(T entity);
    T update(Integer id, T entity);
    T delete(Integer id);
}
