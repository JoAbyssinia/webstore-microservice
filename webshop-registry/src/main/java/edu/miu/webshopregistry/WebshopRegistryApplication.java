package edu.miu.webshopregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class WebshopRegistryApplication {
	public static void main(String[] args) {
		SpringApplication.run(WebshopRegistryApplication.class, args);
	}

}
