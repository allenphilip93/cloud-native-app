package com.cloudnative.services.customers.service;

import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;

import com.cloudnative.services.customers.model.EntityPOJO;
import com.github.javafaker.Faker;

import org.springframework.stereotype.Service;

@Service
public class GeneratorService {
    
    public EntityPOJO generateNewPojo() {
        EntityPOJO pojo = new EntityPOJO();
        // Pick random data to fill up the data based on config yml
        Faker faker = new Faker();
        pojo.setId(faker.idNumber().invalid());
        String email = faker.internet().emailAddress();
        pojo.setName(Arrays.stream(email.split("@")[0].split("\\."))
            .map(e -> toCamelCase(e)).collect(Collectors.joining(" ")));
        pojo.setEmail(email);
        pojo.setGender(faker.demographic().sex());
        pojo.setAge(faker.number().numberBetween(18, 100));
        pojo.setCity(faker.address().city());
        pojo.setState(faker.address().state());
        pojo.setCountry(faker.address().country());
        pojo.setCreatedOn(new Date());
        return pojo;
    }

    public static String toCamelCase(final String init) {
        if (init == null)
            return null;
    
        final StringBuilder ret = new StringBuilder(init.length());
    
        for (final String word : init.split(" ")) {
            if (!word.isEmpty()) {
                ret.append(Character.toUpperCase(word.charAt(0)));
                ret.append(word.substring(1).toLowerCase());
            }
            if (!(ret.length() == init.length()))
                ret.append(" ");
        }
    
        return ret.toString();
    }
}
