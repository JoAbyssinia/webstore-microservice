package edu.miu.ShoppingCartQuery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.EnableKafkaStreams;

@SpringBootApplication
@EnableDiscoveryClient
@EnableKafka
public class ShoppingCartQueryApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingCartQueryApplication.class, args);
    }

}