package edu.miu.shoppingcartcommand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.EnableKafkaStreams;

//8095
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableKafka
@EnableKafkaStreams
public class ShoppingcartCommandApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingcartCommandApplication.class, args);
	}

}
