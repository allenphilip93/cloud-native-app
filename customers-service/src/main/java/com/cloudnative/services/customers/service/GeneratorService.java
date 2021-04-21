package com.cloudnative.services.customers.service;

import com.cloudnative.services.customers.model.EntityPOJO;
import com.cloudnative.services.customers.repository.ApiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneratorService {
    
    private final ApiRepository repository;

    @Autowired
    public GeneratorService(ApiRepository repository) {
        this.repository = repository;
    }

    public EntityPOJO generateNewPojo() {
        EntityPOJO pojo = new EntityPOJO();
        // Auto-generate customer id
        // Pick random data to fill up the data based on config yml
        return pojo;
    }
}
