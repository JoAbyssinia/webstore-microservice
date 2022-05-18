package edu.miu.shoppingcartcommand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

//8095
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ShoppingcartCommandApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingcartCommandApplication.class, args);
	}

}
