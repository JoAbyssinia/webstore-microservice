package edu.miu.ShoppingCartQuery.service;


import edu.miu.ShoppingCartQuery.dto.request.ProductDTO;
import edu.miu.ShoppingCartQuery.dto.request.ShoppingCartQueryRequestDTO;
import edu.miu.ShoppingCartQuery.dto.responce.ShoppingCartQueryResponseDTO;

import java.util.List;

public interface ShoppingCartService {

    ShoppingCartQueryResponseDTO addShoppingCartQuery(ShoppingCartQueryRequestDTO shoppingCartQueryRequestDTO);


    ShoppingCartQueryResponseDTO addProduct(ShoppingCartQueryRequestDTO shoppingCartQueryRequestDTO);

    ShoppingCartQueryResponseDTO removeProduct(String cartNumber, ProductDTO productDTO);

    ShoppingCartQueryResponseDTO changeProduct(String cartNumber, ProductDTO productDTO,Integer quantity);

    ShoppingCartQueryResponseDTO deleteShoppingCartQuery(String cartNumber);

    ShoppingCartQueryResponseDTO getShoppingCartQuery(String cartNumber);

    List<ShoppingCartQueryResponseDTO> getAllShoppingCartQuery();

    String getShoppingCartQueryCheckout(String cartNumber, String customerId);



}
