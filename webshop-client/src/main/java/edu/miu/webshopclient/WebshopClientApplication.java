package edu.miu.webshopclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class WebshopClientApplication implements CommandLineRunner {

	@Autowired
	private RestOperations restTemplate;

	public static void main(String[] args) {
		SpringApplication.run(WebshopClientApplication.class, args);
	}

	@Bean
	RestOperations restTemplate() {
		return new RestTemplate();
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
