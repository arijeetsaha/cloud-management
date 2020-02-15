### Monitoring Service - Hystrix Turbine

####Start Application -
mvn spring-boot:run

1. Dashboard URL - http://localhost:8989/hystrix
2. Turbine Stream - http://localhost:8989/turbine.stream?cluster=CUSTOMER-SERVICE

The classic Turbine model of pulling metrics from all the distributed Hystrix commands is not always a good choice. An operation such as collecting metrics from HTTP endpoints may also be realized asynchronously with a message broker. To enable Turbine with streaming-

1. @EnableTurbineStream
2. ```
   <dependency> 
        <groupId>org.springframework.cloud</groupId> 
        <artifactId>spring-cloud-starter-turbine-stream</artifactId>
   </dependency>
   <dependency> 
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-stream-kafka</artifactId>
   </dependency>
   ```