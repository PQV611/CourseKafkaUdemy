package com.course.kafka.service;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductCreateEvent {
    private String productId ;
    private String title ;
    private BigDecimal price ;
    private Integer quantity ;
}
