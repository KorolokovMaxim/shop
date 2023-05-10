package com.korolkov.shop.service.base;

import java.util.List;

public interface BaseCRUDService<T> {

    void  create(T request);

    void delete(Long id);

    List<T> getAll();

    T getOne(Long id);
}
