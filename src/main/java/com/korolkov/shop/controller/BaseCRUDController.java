package com.korolkov.shop.controller;

import java.util.List;
import java.util.UUID;

public interface BaseCRUDController<T> {
     void  create(T request);

     void delete(UUID id);

     List<T> getAll();

     T getOne(UUID id);

}
