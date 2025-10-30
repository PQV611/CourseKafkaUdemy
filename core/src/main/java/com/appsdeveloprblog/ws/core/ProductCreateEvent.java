package com.appsdeveloprblog.ws.core;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductCreateEvent {
    private String productId ;
    private String title ;
    private BigDecimal price ;
    private Integer quantity ;
}
