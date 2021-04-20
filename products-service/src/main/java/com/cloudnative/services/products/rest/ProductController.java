package com.cloudnative.services.products.rest;

import com.cloudnative.services.products.mapper.MapperI;
import com.cloudnative.services.products.model.Product;
import com.cloudnative.services.products.rest.dto.CreateProductDto;
import com.cloudnative.services.products.service.ApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ApiService productService;
    private final MapperI mapper;

    @GetMapping
    public List<Product> getAll() {
        List<Product> products = productService.getAll();
        log.info("Get all products", v("numProductsReturned", products.size()));
        return products;
    }

    @GetMapping("/{id}")
    public Product get(@PathVariable("id") String id) {
        log.info("Get product", v("id", id));
        return productService.validateAndGet(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Product create(@Valid @RequestBody CreateProductDto createProductDto) {
        Product product = mapper.map(createProductDto);
        product = productService.create(product);
        log.info("Product created", v("id", product.getImdb()));
        return product;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") String imdb) {
        Product product = productService.validateAndGet(imdb);
        productService.delete(product);
        log.info("Product deleted", v("id", product.getImdb()));
        return product.getImdb();
    }

}
