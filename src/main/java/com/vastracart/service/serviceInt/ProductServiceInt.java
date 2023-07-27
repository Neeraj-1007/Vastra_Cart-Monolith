package com.vastracart.service.serviceInt;

import com.vastracart.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductServiceInt {

    Optional<Product> getByName(String name);

    Optional<Product> getById(Long id);

    List<Product> getList();

    Product saveProduct(Product product);

    void updateProduct(String name,Long id);
}
