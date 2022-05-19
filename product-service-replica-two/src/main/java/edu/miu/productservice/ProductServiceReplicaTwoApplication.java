package edu.miu.productservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ProductServiceReplicaTwoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceReplicaTwoApplication.class, args);
	}

}
