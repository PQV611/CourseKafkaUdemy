package com.course.kafka.rest;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateProductRestModel {
    private String title;
    private BigDecimal price;
    private Integer quantity;
}
