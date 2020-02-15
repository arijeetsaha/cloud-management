package com.arijeet.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachePut;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import com.arijeet.springcloud.api.Order;

import java.util.Objects;

@RestController
@RequestMapping("/order")
public class CustomerOrderController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerOrderController.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CacheManager cacheManager;

    @HystrixCommand(commandKey = "Customer-PlaceOrder", fallbackMethod = "retryOrder",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "30"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
                    @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "10000")
            })
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Order placeOrder(){
        Order order = restTemplate.postForObject("http://order-service/order", null, Order.class);
        return order;
    }

    public Order retryOrder(){
        LOGGER.info("retry order call");
        return new Order();
    }

    @HystrixCommand(commandKey = "Customer- Get Order",fallbackMethod = "getOrderFallback",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "30"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
                    @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "10000")
            })
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @CachePut("orders")
    public Order getOrder(@PathVariable String id){
        Order order = restTemplate.getForObject("http://order-service/order/{orderid}", Order.class, id);
        return order;
    }

    public Order getOrderFallback(String id){
        LOGGER.info("get order fallback call");
        Cache.ValueWrapper valueWrapper = cacheManager.getCache("orders").get(id);
        if(Objects.nonNull(valueWrapper)){
            return (Order) valueWrapper.get();
        }
        return new Order();
    }

}
