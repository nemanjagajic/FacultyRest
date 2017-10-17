package com.nemanjagajic.controller;

import java.util.List;

public interface BasicController<T> {
    List<T> getAll();
    T getById(Integer id);
    T post(T entity);
    T put(Integer id, T entity);
    T delete(Integer id);
}
