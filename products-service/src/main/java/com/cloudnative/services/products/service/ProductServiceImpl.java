package com.cloudnative.services.products.service;

import com.cloudnative.services.products.exception.ProductNotFoundException;
import com.cloudnative.services.products.model.Product;
import com.cloudnative.services.products.repository.ApiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ApiService {

    private final ApiRepository productRepository;

    @Autowired
    public ProductServiceImpl(ApiRepository producRepository) {
        this.productRepository = producRepository;
    }

    @Override
    public Product validateAndGet(String id) {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void delete(Product product) {
        productRepository.delete(product);
    }

}
