package com.cloudnative.services.sellers.mapper;

import com.cloudnative.services.sellers.model.EntityPOJO;
import com.cloudnative.services.sellers.rest.dto.CreateDto;

import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public EntityPOJO map(CreateDto createDto) {
        EntityPOJO entity = new EntityPOJO();
        entity.setId(createDto.getId());
        entity.setName(createDto.getName());
        entity.setDescr(createDto.getDescr());
        entity.setCity(createDto.getCity());
        entity.setState(createDto.getState());
        entity.setCountry(createDto.getCountry());
        entity.setCreatedOn(createDto.getCreatedOn());
        return entity;
    }

}
