package edu.miu.webshopclient.components;

import com.google.gson.Gson;
import edu.miu.webshopclient.dto.ShoppingCartRequestDTO;
import edu.miu.webshopclient.dto.shoppingcartQuery.ShoppingCartQueryResponseDTO;
import edu.miu.webshopclient.dto.shoppingcartcomponent.ProductRequestDTO;
import edu.miu.webshopclient.dto.shoppingcartcomponent.ShoppingCartResponseDTO;
import edu.miu.webshopclient.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;

import java.util.Arrays;
import java.util.List;

@Component
public class ShoppingCartQueryComponent implements ApplicationRunner {

    @Autowired
    private RestOperations restTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Product> request = new HttpEntity<>(requestHeaders);
        Gson gson = new Gson();
        String shoppingServerUrl = "http://localhost:8080/api/v1/shopping-cart-query";

        System.out.println("********************** ShoppingCart query Request **********************");
        System.out.println();

//
//    		********************** Print all shopping cart **********************
//
//
//
        ResponseEntity<String> productResult1 = restTemplate.exchange(
                shoppingServerUrl,
                HttpMethod.GET,null, String.class);

        List<ShoppingCartQueryResponseDTO> cartResultReturn = gson.fromJson(productResult1.getBody(),
                List.class);

        System.out.println(cartResultReturn);
        System.out.println();



        System.out.println("********************** print getSopping cart Shopping Cart **********************");
//
//
        ResponseEntity<String> getShoppingCart = restTemplate.exchange(
                shoppingServerUrl + "/56883622051910100454",
                HttpMethod.GET, null, String.class);

        ShoppingCartQueryResponseDTO getShoppingCartQ = gson.fromJson(getShoppingCart.getBody(),
                ShoppingCartQueryResponseDTO.class);

        System.out.println(getShoppingCartQ);
        System.out.println();

//
//
//          ============ checkout shoppingCart ==========
//
        ResponseEntity<String> checkoutRequest = restTemplate.exchange(
                shoppingServerUrl +"/checkout/56883622051910100454/808049",
                HttpMethod.GET, null, String.class);

//        String checkout = gson.fromJson(checkoutRequest.getBody(),String.class);

        System.out.println("checkout is done");
        System.out.println();

        System.out.println("checkout over");

//
//        //	********************** checkout from Shopping Cart **********************
//

    }
}
