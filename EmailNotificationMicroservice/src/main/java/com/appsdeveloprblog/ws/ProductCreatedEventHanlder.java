package com.appsdeveloprblog.ws;

import com.appsdeveloprblog.ws.core.ProductCreateEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@KafkaListener(topics = "product-created-events-topic")
public class ProductCreatedEventHanlder {

    private final Logger logger = LoggerFactory.getLogger(this.getClass()) ;

    @KafkaHandler
    public void handle(ProductCreateEvent productCreateEvent){
        logger.info("Received a  new event: {}", productCreateEvent.getTitle());
    }

}
