package com.korolkov.shop.repository.product;

import com.korolkov.shop.entity.product.Product;
import com.korolkov.shop.repository.base.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends BaseRepository<Product> {
}
