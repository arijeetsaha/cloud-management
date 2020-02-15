package com.arijeet.springcloud.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.arijeet.springcloud.api.Order;

import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderResource {

    @Autowired
    private ProductService productService;

    @PostMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public Order create(){
//        try {
//            Thread.sleep(60000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        productService.getProduct("aa");
        UUID uuid = UUID.randomUUID();
        Order order = new Order();
        order.setOrderId(uuid.toString());
        return order;
    }

    @GetMapping( value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Order getOrder(@PathVariable String id){
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Order order = new Order();
        order.setOrderId("O-"+ id);
        return order;
    }

}
