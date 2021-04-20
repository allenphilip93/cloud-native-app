package com.cloudnative.services.payments.mapper;

import com.cloudnative.services.payments.model.EntityPOJO;
import com.cloudnative.services.payments.rest.dto.CreateDto;

import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public EntityPOJO map(CreateDto createDto) {
        EntityPOJO entity = new EntityPOJO();
        entity.setId(createDto.getId());
        entity.setType(createDto.getType());
        entity.setAmount(createDto.getAmount());
        entity.setNumInstallments(createDto.getNumInstallments());
        entity.setCreatedOn(createDto.getCreatedOn());
        return entity;
    }

}
