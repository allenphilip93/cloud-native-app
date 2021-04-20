package com.cloudnative.services.products.mapper;

import com.cloudnative.services.products.model.Product;
import com.cloudnative.services.products.rest.dto.CreateProductDto;

@org.mapstruct.Mapper(componentModel = "spring")
public interface MapperI {

    Product map(CreateProductDto createProductDto);

}
