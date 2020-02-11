package com.arijeet.springcloud.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping(value ="/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity getProductDetails(@PathVariable("id") String id){
        return ResponseEntity.status(HttpStatus.OK).body(id);
    }
}
