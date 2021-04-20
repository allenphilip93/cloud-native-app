package com.cloudnative.services.orders.mapper;

import com.cloudnative.services.orders.model.EntityPOJO;
import com.cloudnative.services.orders.rest.dto.CreateDto;

import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public EntityPOJO map(CreateDto createDto) {
        EntityPOJO entity = new EntityPOJO();
        entity.setId(createDto.getId());
        entity.setCreatedOn(createDto.getCreatedOn());
        entity.setDeliveredOn(createDto.getDeliveredOn());
        entity.setCustomerId(createDto.getCustomerId());
        entity.setPaymentId(createDto.getPaymentId());
        entity.setProductId(createDto.getProductId());
        entity.setSellerId(createDto.getSellerId());
        return entity;
    }

}
