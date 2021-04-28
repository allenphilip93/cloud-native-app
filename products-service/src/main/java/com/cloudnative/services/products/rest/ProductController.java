package com.cloudnative.services.products.rest;

import com.cloudnative.services.products.mapper.Mapper;
import com.cloudnative.services.products.model.EntityPOJO;
import com.cloudnative.services.products.rest.dto.CreateProductDto;
import com.cloudnative.services.products.service.ApiService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

import static net.logstash.logback.argument.StructuredArguments.v;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    private final ApiService productService;
    private final Mapper mapper;

    @Autowired
    public ProductController(ApiService productService, Mapper mapper) {
        this.productService = productService;
        this.mapper = mapper;
    }

    @GetMapping
    public List<EntityPOJO> getAll() {
        List<EntityPOJO> products = productService.getAll();
        log.info("Get all products", v("numProductsReturned", products.size()));
        return products;
    }

    @GetMapping("/{id}")
    public EntityPOJO get(@PathVariable("id") String id) {
        log.info("Get product", v("id", id));
        return productService.validateAndGet(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public EntityPOJO create(@Valid @RequestBody CreateProductDto createProductDto) {
        EntityPOJO product = mapper.map(createProductDto);
        product = productService.create(product);
        log.info("Product created", v("id", product.getId()));
        return product;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") String imdb) {
        EntityPOJO product = productService.validateAndGet(imdb);
        productService.delete(product);
        log.info("Product deleted", v("id", product.getId()));
        return product.getId();
    }

}
