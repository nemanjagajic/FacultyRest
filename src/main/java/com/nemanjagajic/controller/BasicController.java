package com.nemanjagajic.controller;

import java.util.List;

public interface BasicController<T, R> {
    List<T> getAll();
    T getById(Integer id);
    T post(R entity);
    T put(Integer id, R entity);
    T delete(Integer id);
}
