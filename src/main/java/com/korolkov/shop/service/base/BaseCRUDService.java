package com.korolkov.shop.service.base;

import java.util.List;
import java.util.UUID;

public interface BaseCRUDService<T> {

    void  create(T request);

    void delete(UUID id);

    List<T> getAll();

    T getOne(UUID id);
}
