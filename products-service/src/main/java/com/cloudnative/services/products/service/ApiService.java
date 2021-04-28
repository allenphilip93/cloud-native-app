package com.cloudnative.services.products.service;

import java.util.List;

import com.cloudnative.services.products.exception.NotFoundException;
import com.cloudnative.services.products.model.EntityPOJO;
import com.cloudnative.services.products.repository.ApiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApiService {

    private final ApiRepository repository;

    @Autowired
    public ApiService(ApiRepository repository) {
        this.repository = repository;
    }

    public EntityPOJO validateAndGet(String id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public List<EntityPOJO> getAll() {
        return repository.findAll();
    }

    public EntityPOJO create(EntityPOJO product) {
        return repository.save(product);
    }

    public void delete(EntityPOJO product) {
        repository.delete(product);
    }

    
}
