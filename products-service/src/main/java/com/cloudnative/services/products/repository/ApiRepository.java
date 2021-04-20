package com.cloudnative.services.products.repository;

import com.cloudnative.services.products.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApiRepository extends JpaRepository<Product, String> {
}
