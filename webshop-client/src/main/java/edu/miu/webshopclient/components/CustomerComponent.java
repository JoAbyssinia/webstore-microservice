package edu.miu.webshopclient.components;

import com.google.gson.Gson;
import edu.miu.webshopclient.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;

import java.util.Arrays;

@Component
public class CustomerComponent implements ApplicationRunner {
    @Autowired
    private RestOperations restTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {


        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Customer> request = new HttpEntity<>(requestHeaders);
        Gson gson = new Gson();
        String customerServerUrl = "http://localhost:8090/api/v1/customers/";

        /**
        String customerID = "11111";

        System.out.println("##### REQUESTING CUSTOMER  #####");
        System.out.println();

        System.out.println("##### ----- GET /api/v1/customers/{customerID} ----- ##### ");


        ResponseEntity<String> customerAsString = restTemplate.exchange(
                customerServerUrl+customerID, HttpMethod.GET, request, String.class);

        if(customerAsString != null){
            Customer dto = gson.fromJson(customerAsString.getBody(), Customer.class);
            System.out.println(dto.toString());
        }
        System.out.println();

        System.out.println("##### ----- POST /api/v1/customers ----- ##### ");

        Customer sampleCustomer = Customer.builder()
                .firstName("Bishow")
                .lastName("Shrestha")
                .street("1000 N 4th Street")
                .city("Fairfield")
                .zip(52557)
                .phone("234-455-1323")
                .email("test@gmail.com")
                .build();


        HttpEntity<?> customerHttpEntity = new HttpEntity<>(sampleCustomer,requestHeaders);

        ResponseEntity<String> customer = restTemplate.exchange(
                customerServerUrl,
                HttpMethod.POST, customerHttpEntity, String.class);

        Customer customerCreatedResult = gson.fromJson(customer.getBody(), Customer.class);
        System.out.println("############# CUSTOMER CREATED SUCCESSFULLY #############");
        System.out.println(customerCreatedResult.toString());
        **/
    }
}
