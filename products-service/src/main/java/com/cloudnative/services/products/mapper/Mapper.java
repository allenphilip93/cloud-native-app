package com.cloudnative.services.products.mapper;

import com.cloudnative.services.products.model.EntityPOJO;
import com.cloudnative.services.products.rest.dto.CreateProductDto;

import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public EntityPOJO map(CreateProductDto createProductDto) {
        EntityPOJO product = new EntityPOJO();
        product.setId(createProductDto.getId());
        product.setCategory(createProductDto.getCategory());
        product.setSubcategory(createProductDto.getSubcategory());
        product.setBrand(createProductDto.getBrand());
        product.setPrice(createProductDto.getPrice());
        product.setDescr(createProductDto.getDescr());
        product.setAddedOn(createProductDto.getAddedOn());
        return product;
    }

}
