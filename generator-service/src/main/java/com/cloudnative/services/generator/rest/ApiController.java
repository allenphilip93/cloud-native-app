package com.cloudnative.services.generator.rest;

import java.util.Set;

import com.cloudnative.services.generator.schedule.CustomerTask;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.ScheduledAnnotationBeanPostProcessor;
import org.springframework.scheduling.config.ScheduledTask;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:8060")
@RequestMapping("/api/generator")
public class ApiController {
    
    private static final Logger log = LoggerFactory.getLogger(ApiController.class);
    private static final String SCHEDULED_CUSTOMER_TASK = "customerTask";
    
    @Autowired
    private ScheduledAnnotationBeanPostProcessor postProcessor;
    
    @Autowired
    private CustomerTask customerTask;
    
    @Autowired
    private ObjectMapper objectMapper;
    
    @PutMapping(value = "/stopCustomerTask")
    public ResponseEntity<String> stopCustomerTask(){
        postProcessor.postProcessBeforeDestruction(customerTask, SCHEDULED_CUSTOMER_TASK);
        log.info("Stopped scheduler");
        return ResponseEntity.ok("OK");
    }
    
    @PutMapping(value = "/startCustomerTask")
    public ResponseEntity<String> startCustomerTask(){
        postProcessor.postProcessAfterInitialization(customerTask, SCHEDULED_CUSTOMER_TASK);
        log.info("Started scheduler");
        return ResponseEntity.ok("OK");
    }
    
    @GetMapping(value = "/listScheduler")
    public String listSchedules() throws JsonProcessingException{
        Set<ScheduledTask> setTasks = postProcessor.getScheduledTasks();
        if(!setTasks.isEmpty()){
            return objectMapper.writeValueAsString(setTasks);
        }else{
            return "No running tasks !";
        }
    }
}
