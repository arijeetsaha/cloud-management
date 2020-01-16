package com.arijeet.springcloud.eurekaserver;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaserverApplication {

    public static void main(String[] args) {

    	new SpringApplicationBuilder(EurekaserverApplication.class).run(args);
    }

}
