package com.arijeet.springcloud.resource;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service")
public interface ProductService {

    @GetMapping("/products/{id}")
    ResponseEntity getProduct(@PathVariable("id") String productId);
}
