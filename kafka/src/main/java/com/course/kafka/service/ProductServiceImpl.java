package com.course.kafka.service;


import com.appsdeveloprblog.ws.core.ProductCreateEvent;
import com.course.kafka.rest.CreateProductRestModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    KafkaTemplate<String, ProductCreateEvent> kafkaTemplate;
    private final Logger logger = LoggerFactory.getLogger(this.getClass()) ;

    public ProductServiceImpl(KafkaTemplate<String, ProductCreateEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public String createProduct(CreateProductRestModel product) throws Exception {
        String productId = UUID.randomUUID().toString() ;
        ProductCreateEvent productCreateEvent = new ProductCreateEvent(productId, product.getTitle(), product.getPrice(), product.getQuantity()) ;

        logger.info("[START RUN KAFKA]");

        SendResult<String, ProductCreateEvent> result = kafkaTemplate.send("topic2", productId, productCreateEvent).get();
        logger.info("Partition: {}", result.getRecordMetadata().partition());
        logger.info("Topic: {}", result.getRecordMetadata().topic());
        logger.info("Offset: {}", result.getRecordMetadata().offset());
        logger.info("[FINISH RUN KAFKA]");
        return productId ;
    }
}
