package edu.miu.webshopclient.components;

import com.google.gson.Gson;
import edu.miu.webshopclient.constant.APIConstant;
import edu.miu.webshopclient.dto.OrderConfirmRequestDTO;
import edu.miu.webshopclient.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;

import java.util.Arrays;

@Component
public class OrderComponent implements ApplicationRunner {
    @Autowired
    private RestOperations restTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        
        /**

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Customer> request = new HttpEntity<>(requestHeaders);
        Gson gson = new Gson();
        String orderNumber = "93";

        System.out.println("##### REQUESTING ORDER COMPONENT #####");

        System.out.println("##### ----- GET /api/v1/orders/{orderNumber} ----- ##### ");
        ResponseEntity<String> shoppingCartListResult = restTemplate.exchange(
                APIConstant.ORDER_API + orderNumber,
                HttpMethod.GET, request, String.class);

        System.out.println(shoppingCartListResult.getBody());
        System.out.println("############# FETCHED ORDER SUCCESSFULLY #############");

        System.out.println("##### ----- GET /api/v1/orders/confirm ----- ##### ");

        OrderConfirmRequestDTO orderConfirmRequestDTO = OrderConfirmRequestDTO.builder()
                .orderNumber("93")
                .customerID("11111")
                .build();

        HttpEntity<OrderConfirmRequestDTO> request2 = new HttpEntity<>(orderConfirmRequestDTO,requestHeaders);
        ResponseEntity<String> orderResult = restTemplate.exchange(
                APIConstant.ORDER_API+"/confirm",
                HttpMethod.POST, request2, String.class);

        System.out.println(orderResult.getBody());
        System.out.println("############# CONFIRMED ORDER SUCCESSFULLY #############");


        **/
    }
}
