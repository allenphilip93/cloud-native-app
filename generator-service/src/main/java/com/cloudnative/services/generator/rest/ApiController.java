package com.cloudnative.services.generator.rest;

import java.util.Set;

import com.cloudnative.services.generator.schedule.CustomerTask;
import com.cloudnative.services.generator.schedule.OrderTask;
import com.cloudnative.services.generator.schedule.PaymentTask;
import com.cloudnative.services.generator.schedule.ProductTask;
import com.cloudnative.services.generator.schedule.ReviewTask;
import com.cloudnative.services.generator.schedule.SellerTask;
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
    private static final String SCHEDULED_ORDER_TASK = "orderTask";
    private static final String SCHEDULED_SELLER_TASK = "sellerTask";
    private static final String SCHEDULED_REVIEW_TASK = "reviewTask";
    private static final String SCHEDULED_PRODUCT_TASK = "productTask";
    private static final String SCHEDULED_PAYMENT_TASK = "paymentTask";
    
    @Autowired
    private ScheduledAnnotationBeanPostProcessor postProcessor;
    
    @Autowired
    private CustomerTask customerTask;

    @Autowired
    private OrderTask orderTask;

    @Autowired
    private SellerTask sellerTask;

    @Autowired
    private ReviewTask reviewTask;

    @Autowired
    private ProductTask productTask;

    @Autowired
    private PaymentTask PaymentTask;
    
    @Autowired
    private ObjectMapper objectMapper;
    
    @PutMapping(value = "/startCustomerTask")
    public ResponseEntity<String> startCustomerTask(){
        postProcessor.postProcessAfterInitialization(customerTask, SCHEDULED_CUSTOMER_TASK);
        log.info("Started scheduler");
        return ResponseEntity.ok("OK");
    }
    
    @PutMapping(value = "/stopCustomerTask")
    public ResponseEntity<String> stopCustomerTask(){
        postProcessor.postProcessBeforeDestruction(customerTask, SCHEDULED_CUSTOMER_TASK);
        log.info("Stopped scheduler");
        return ResponseEntity.ok("OK");
    }
    
    @PutMapping(value = "/startOrderTask")
    public ResponseEntity<String> startOrderTask(){
        postProcessor.postProcessAfterInitialization(orderTask, SCHEDULED_ORDER_TASK);
        log.info("Started scheduler");
        return ResponseEntity.ok("OK");
    }
    
    @PutMapping(value = "/stopOrderTask")
    public ResponseEntity<String> stopOrderTask(){
        postProcessor.postProcessBeforeDestruction(orderTask, SCHEDULED_ORDER_TASK);
        log.info("Stopped scheduler");
        return ResponseEntity.ok("OK");
    }

    @PutMapping(value = "/startSellerTask")
    public ResponseEntity<String> startSellerTask(){
        postProcessor.postProcessAfterInitialization(sellerTask, SCHEDULED_SELLER_TASK);
        log.info("Started scheduler");
        return ResponseEntity.ok("OK");
    }
    
    @PutMapping(value = "/stopSellerTask")
    public ResponseEntity<String> stopSellerTask(){
        postProcessor.postProcessBeforeDestruction(sellerTask, SCHEDULED_SELLER_TASK);
        log.info("Stopped scheduler");
        return ResponseEntity.ok("OK");
    }

    @PutMapping(value = "/startReviewTask")
    public ResponseEntity<String> startReviewTask(){
        postProcessor.postProcessAfterInitialization(reviewTask, SCHEDULED_REVIEW_TASK);
        log.info("Started scheduler");
        return ResponseEntity.ok("OK");
    }
    
    @PutMapping(value = "/stopReviewTask")
    public ResponseEntity<String> stopReviewTask(){
        postProcessor.postProcessBeforeDestruction(reviewTask, SCHEDULED_REVIEW_TASK);
        log.info("Stopped scheduler");
        return ResponseEntity.ok("OK");
    }

    @PutMapping(value = "/startProductTask")
    public ResponseEntity<String> startProductTask(){
        postProcessor.postProcessAfterInitialization(productTask, SCHEDULED_PRODUCT_TASK);
        log.info("Started scheduler");
        return ResponseEntity.ok("OK");
    }
    
    @PutMapping(value = "/stopProductTask")
    public ResponseEntity<String> stopProductTask(){
        postProcessor.postProcessBeforeDestruction(productTask, SCHEDULED_PRODUCT_TASK);
        log.info("Stopped scheduler");
        return ResponseEntity.ok("OK");
    }

    @PutMapping(value = "/startPaymentTask")
    public ResponseEntity<String> startPaymentTask(){
        postProcessor.postProcessAfterInitialization(PaymentTask, SCHEDULED_PAYMENT_TASK);
        log.info("Started scheduler");
        return ResponseEntity.ok("OK");
    }
    
    @PutMapping(value = "/stopPaymentTask")
    public ResponseEntity<String> stopPaymentTask(){
        postProcessor.postProcessBeforeDestruction(PaymentTask, SCHEDULED_PAYMENT_TASK);
        log.info("Stopped scheduler");
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
