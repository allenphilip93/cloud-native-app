package com.cloudnative.services.payments.rest;

import com.cloudnative.services.payments.mapper.Mapper;
import com.cloudnative.services.payments.model.EntityPOJO;
import com.cloudnative.services.payments.rest.dto.CreateDto;
import com.cloudnative.services.payments.service.ApiService;

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
@RequestMapping("/api/payments")
public class ApiController {

    private static final Logger log = LoggerFactory.getLogger(ApiController.class);
    
    private final ApiService apiService;
    private final Mapper mapper;

    @Autowired
    public ApiController(ApiService apiService, Mapper mapper) {
        this.apiService = apiService;
        this.mapper = mapper;
    }

    @GetMapping
    public List<EntityPOJO> getAll() {
        List<EntityPOJO> entities = apiService.getAll();
        log.info("Get all payments", v("numReturned", entities.size()));
        return entities;
    }

    @GetMapping("/{id}")
    public EntityPOJO get(@PathVariable("id") String id) {
        log.info("Get payment", v("id", id));
        return apiService.validateAndGet(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public EntityPOJO create(@Valid @RequestBody CreateDto createProductDto) {
        EntityPOJO entity = mapper.map(createProductDto);
        entity = apiService.create(entity);
        log.info("Payment created", v("id", entity.getId()));
        return entity;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") String id) {
        EntityPOJO entity = apiService.validateAndGet(id);
        apiService.delete(entity);
        log.info("Payment deleted", v("id", entity.getId()));
        return entity.getId();
    }

}
