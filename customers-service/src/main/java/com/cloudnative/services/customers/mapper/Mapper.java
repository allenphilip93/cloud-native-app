package com.cloudnative.services.customers.mapper;

import com.cloudnative.services.customers.model.EntityPOJO;
import com.cloudnative.services.customers.rest.dto.CreateDto;

import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public EntityPOJO map(CreateDto createDto) {
        EntityPOJO entity = new EntityPOJO();
        entity.setId(createDto.getId());
        entity.setName(createDto.getName());
        entity.setAge(createDto.getAge());
        entity.setEmail(createDto.getEmail());
        entity.setGender(createDto.getGender());
        entity.setCity(createDto.getCity());
        entity.setState(createDto.getState());
        entity.setCountry(createDto.getCountry());
        return entity;
    }

}
