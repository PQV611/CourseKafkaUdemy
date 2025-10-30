package com.course.kafka.service;

import com.course.kafka.rest.CreateProductRestModel;

public interface ProductService {
    String createProduct(CreateProductRestModel productRestModel) throws Exception ;
}
