package com.cloudnative.services.products.service;

import com.cloudnative.services.products.model.Product;

import java.util.List;

public interface ApiService {

    Product validateAndGet(String imdb);

    List<Product> getAll();

    Product create(Product product);

    void delete(Product product);

}
