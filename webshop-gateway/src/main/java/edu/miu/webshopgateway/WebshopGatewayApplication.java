package edu.miu.webshopgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class WebshopGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebshopGatewayApplication.class, args);
	}

}
