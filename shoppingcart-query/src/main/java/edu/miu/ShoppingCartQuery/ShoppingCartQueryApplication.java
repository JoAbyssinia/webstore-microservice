package edu.miu.ShoppingCartQuery;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.EnableKafkaStreams;

@SpringBootApplication
@EnableDiscoveryClient
@EnableKafka
@EnableFeignClients
public class ShoppingCartQueryApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingCartQueryApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("application is running");
    }
}
