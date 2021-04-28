package com.cloudnative.services.reviews.service;

import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;

import com.cloudnative.services.reviews.model.EntityPOJO;
import com.github.javafaker.Faker;

import org.springframework.stereotype.Service;

@Service
public class GeneratorService {
    
    public EntityPOJO generateNewPojo() {
        EntityPOJO pojo = new EntityPOJO();
        // Pick random data to fill up the data based on config yml
        Faker faker = new Faker();
        pojo.setId(faker.idNumber().invalid());
        pojo.setCreatedOn(new Date());
        //TODO
        return pojo;
    }
}
