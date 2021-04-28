package com.cloudnative.services.products.service;

import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;

import com.cloudnative.services.products.model.EntityPOJO;
import com.github.javafaker.Faker;

import org.springframework.stereotype.Service;

@Service
public class GeneratorService {
    
    public EntityPOJO generateNewPojo() {
        EntityPOJO pojo = new EntityPOJO();
        // Pick random data to fill up the data based on config yml
        Faker faker = new Faker();
        pojo.setId(faker.idNumber().invalid());
        // TODO
        return pojo;
    }
}
