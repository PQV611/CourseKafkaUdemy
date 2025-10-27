package com.course.kafka.service;


import com.course.kafka.rest.CreateProductRestModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class ProductServiceImpl implements ProductService {

    KafkaTemplate<String, ProductCreateEvent> kafkaTemplate;
    private final Logger logger = LoggerFactory.getLogger(this.getClass()) ;

    public ProductServiceImpl(KafkaTemplate<String, ProductCreateEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public String createProduct(CreateProductRestModel product) {
        String productId = UUID.randomUUID().toString() ;
        ProductCreateEvent productCreateEvent = new ProductCreateEvent(productId, product.getTitle(), product.getPrice(), product.getQuantity()) ;

        CompletableFuture<SendResult<String, ProductCreateEvent>> future = kafkaTemplate.send("product-created-events-topic", productId, productCreateEvent);

        future.whenComplete((result, exception) -> {
            if (exception != null) {
                logger.error("Run Kafka failed: " + exception.getMessage());
            }else {
                logger.info("Run Kafka completed with productId: "  + result.getRecordMetadata());
            }
        }) ;

        return productId ;
    }
}
