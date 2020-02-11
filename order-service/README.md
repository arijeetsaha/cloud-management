###Start Application

mvn spring-boot:run -Dspring-boot.run.arguments=--order.service.port=7000,SEQUENCE_NO=1

mvn spring-boot:run -Dspring-boot.run.arguments=--order.service.port=7001,SEQUENCE_NO=2

This service uses ```feign client``` to make HTTP calls to product service.