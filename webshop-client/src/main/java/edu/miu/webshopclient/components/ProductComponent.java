package edu.miu.webshopclient.components;

import com.google.gson.Gson;
import edu.miu.webshopclient.dto.ProductResponseDTO;
import edu.miu.webshopclient.entity.Customer;
import edu.miu.webshopclient.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;

import java.util.Arrays;

@Component
public class ProductComponent implements ApplicationRunner {

    @Autowired
    private RestOperations restTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Customer> request = new HttpEntity<>(requestHeaders);
        Gson gson = new Gson();
        String productServerUrl = "http://localhost:8080/api/v1/product/";

/**
        System.out.println("##### REQUESTING PRODUCT \n #####");

        System.out.println("***** +++++ ADDING  PRODUCT +++++ *****");
        System.out.println("##### ----- POST /api/v1/product ----- #####");

		Product product1 = Product.builder()
                .productNumber("5")
                .name("Apple 5")
                .price(1000.00)
                .description("Product by Apple Inc.")
                .quantity(1000)
                .build();
		HttpEntity<Product> request1 = new HttpEntity<>(product1,requestHeaders);
		ResponseEntity<String> productResult1 = restTemplate.exchange(
				productServerUrl,
				HttpMethod.POST, request1, String.class);

        ProductResponseDTO productCreatedResultReturn = gson.fromJson(productResult1.getBody(), ProductResponseDTO.class);

		System.out.println("RESPONSE: " + productCreatedResultReturn.toString());
        System.out.println("############# PRODUCT CREATED SUCCESSFULLY #############");


        System.out.println("***** +++++ UPDATING  PRODUCT +++++ *****");
        System.out.println("##### ----- PUT /api/v1/product ----- ##### ");

		Product product2 = Product.builder()
                .productNumber(productCreatedResultReturn.getProductNumber())
                .name("M1 Mac Air 13")
                .price(1299.00)
                .description("Apple Product Laptops")
                .build();

		HttpEntity<?> request2 = new HttpEntity<>(product2, requestHeaders);
		ResponseEntity<String> productResult2 = restTemplate.exchange(
				productServerUrl+"/"+productCreatedResultReturn.getProductNumber(),
				HttpMethod.PUT, request2, String.class);

		ProductResponseDTO productUpdatedResultReturn = gson.fromJson(productResult2.getBody(), ProductResponseDTO.class);

        System.out.println("RESPONSE: " + productUpdatedResultReturn.toString() + "\n");
        System.out.println("############# PRODUCT UPDATED SUCCESSFULLY #############");


        System.out.println("***** +++++ GET PRODUCT BY PRODUCT NUMBER +++++ *****");
        System.out.println("##### ----- GET /api/v1/product/{productNumber} ----- ##### ");


		ResponseEntity<String> productResult3 = restTemplate.exchange(
				productServerUrl+productCreatedResultReturn.getProductNumber(),
				HttpMethod.GET, request, String.class);

        ProductResponseDTO productResultReturn = gson.fromJson(productResult3.getBody(), ProductResponseDTO.class);
        System.out.println("RESPONSE: " + productResultReturn.toString() + "\n");

        System.out.println("############# PRODUCT FETCHED SUCCESSFULLY #############");


 **/
    }
}
