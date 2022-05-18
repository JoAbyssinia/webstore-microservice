package edu.miu.shoppingcartcommand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//8095
@SpringBootApplication
@EnableDiscoveryClient
public class ShoppingcartCommandApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingcartCommandApplication.class, args);
	}

}
