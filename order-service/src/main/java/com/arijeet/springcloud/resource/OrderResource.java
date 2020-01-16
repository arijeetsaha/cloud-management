package com.arijeet.springcloud.resource;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.arijeet.springcloud.api.Order;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderResource {

    @PostMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public Order create(){

        UUID uuid = UUID.randomUUID();
        Order order = new Order();
        order.setOrderId(uuid.toString());
        return order;
    }


}
