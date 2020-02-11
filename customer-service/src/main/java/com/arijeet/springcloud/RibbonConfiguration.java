package com.arijeet.springcloud;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class RibbonConfiguration {

    @Autowired
    IClientConfig ribbonClientConfig;

    @Bean
    public IPing ribbonPing(IClientConfig iClientConfig){
        return new PingUrl();
    }

//    @Bean
//    public IRule ribbonRule(IClientConfig iClientConfig){
        // Below are the load balancing rules -
//        new RoundRobinRule();
//        new WeightedResponseTimeRule();
//        new BestAvailableRule();
//        return new AvailabilityFilteringRule();
//    }
}
