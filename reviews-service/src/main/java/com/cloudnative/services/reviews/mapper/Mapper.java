package com.cloudnative.services.reviews.mapper;

import com.cloudnative.services.reviews.model.EntityPOJO;
import com.cloudnative.services.reviews.rest.dto.CreateDto;

import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public EntityPOJO map(CreateDto createDto) {
        EntityPOJO entity = new EntityPOJO();
        entity.setId(createDto.getId());
        entity.setScore(createDto.getScore());
        entity.setComment(createDto.getComment());
        entity.setCreatedOn(createDto.getCreatedOn());
        entity.setCustomerId(createDto.getCustomerId());
        entity.setOrderId(createDto.getOrderId());
        entity.setProductId(createDto.getProductId());
        return entity;
    }

}
