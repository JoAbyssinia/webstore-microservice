package edu.miu.webshopclient.components;

import com.google.gson.Gson;
import edu.miu.webshopclient.dto.ShoppingCartRequestDTO;
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

@Component
public class ShoppingCartComponent implements ApplicationRunner {

    @Autowired
    private RestOperations restTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Product> request = new HttpEntity<>(requestHeaders);
        Gson gson = new Gson();
        String shoppingServerUrl = "http://localhost:8080/api/v1/shopping-cart";

        System.out.println("********************** ShoppingCart Command Request **********************");
        System.out.println();

//
//    		********************** Put Product to Shopping Cart for the first time **********************
//
//
//        ShoppingCartRequestDTO shoppingCartRequestDTO = ShoppingCartRequestDTO.builder()
//                .productNumber("1")
//                .quantity(2)
//                .build();
//
//
//        HttpEntity<ShoppingCartRequestDTO> request1 = new HttpEntity<>(shoppingCartRequestDTO, requestHeaders);
//        ResponseEntity<String> productResult1 = restTemplate.exchange(
//                shoppingServerUrl,
//                HttpMethod.POST, request1, String.class);
//
//        ShoppingCartResponseDTO cartResultReturn = gson.fromJson(productResult1.getBody(),
//                ShoppingCartResponseDTO.class);
//        System.out.println(cartResultReturn);
//        System.out.println();
////
////
////        System.out.println("********************** Product Added to Shopping Cart **********************");
////
////
////
////
////        //		********************** Put Product to Shopping Cart **********************
////
//        ShoppingCartRequestDTO addProductToShoppingCart = ShoppingCartRequestDTO.builder()
//                .productNumber("2")
//                .quantity(12)
//                .build();
//
//        HttpEntity<ShoppingCartRequestDTO> productAdd = new HttpEntity<>(addProductToShoppingCart, requestHeaders);
//
//        ResponseEntity<String> addProduct = restTemplate.exchange(
//                shoppingServerUrl + "/" + cartResultReturn.getCartNumber() + "/product/add",
//                HttpMethod.POST, productAdd, String.class);
//
//
//        ShoppingCartResponseDTO addProductShoppingCart = gson.fromJson(addProduct.getBody(), ShoppingCartResponseDTO.class);
//        System.out.println(addProductShoppingCart);
//        System.out.println();
//
////        System.out.println("********************** Product Added to Already Created Shopping Cart **********************");
////
////
////
////  ============ Delete Product to Shopping Cart ===========
//
//        ProductRequestDTO deleteRequest = ProductRequestDTO.builder()
//                .productNumber("2")
//                .name("Samsung S33")
//                .price(1500.0)
//                .description("this is phone")
//                .build();
//
//
//        HttpEntity<ProductRequestDTO> deleteProduct =
//                new HttpEntity<>(deleteRequest, requestHeaders);
//
//
//        ResponseEntity<String> deleteProductFromShoppingCart = restTemplate.exchange(
//                shoppingServerUrl + "/" + cartResultReturn.getCartNumber() + "/product/remove",
//                HttpMethod.DELETE, deleteProduct, String.class);
//
//        ShoppingCartResponseDTO cartResultReturnDelete = gson.fromJson(deleteProductFromShoppingCart.getBody(),
//                ShoppingCartResponseDTO.class);
//        System.out.println(cartResultReturnDelete);
//        System.out.println();
////
////
////
////
////
////        //	********************** Change quantity from Shopping Cart **********************
////
//
//        ShoppingCartRequestDTO changeQuantityRequest = ShoppingCartRequestDTO.builder()
//                .productNumber("1")
//                .quantity(200)
//                .build();
//
//        HttpEntity<ShoppingCartRequestDTO> requestChange = new HttpEntity<>(changeQuantityRequest, requestHeaders);
//        ResponseEntity<String> changeProductResult = restTemplate.exchange(
//                shoppingServerUrl+"/"+ cartResultReturn.getCartNumber()+"/product/change-quantity",
//                HttpMethod.PUT, requestChange, String.class);
//
//        ShoppingCartResponseDTO changeProductResponse = gson.fromJson(changeProductResult.getBody(),
//                ShoppingCartResponseDTO.class);
//        System.out.println(changeProductResponse);
//        System.out.println();
//
////        System.out.println("********************** Product change from Shopping Cart **********************");


    }
}
