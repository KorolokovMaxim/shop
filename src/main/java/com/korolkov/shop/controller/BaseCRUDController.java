package com.korolkov.shop.controller;

import java.util.List;

public interface BaseCRUDController<T> {
     void  create(T request);

     void delete(Long id);

     List<T> getAll();

     T getOne(Long id);

}
