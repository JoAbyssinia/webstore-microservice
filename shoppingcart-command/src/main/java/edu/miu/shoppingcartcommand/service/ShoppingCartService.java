package edu.miu.shoppingcartcommand.service;

import edu.miu.shoppingcartcommand.dto.request.ShoppingCartRequestDTO;
import edu.miu.shoppingcartcommand.dto.response.ShoppingCartResponseDTO;
import edu.miu.shoppingcartcommand.error.GenericShoppingCartError;

public interface ShoppingCartService {
    ShoppingCartResponseDTO addCart(ShoppingCartRequestDTO shoppingCartRequestDTO) throws GenericShoppingCartError;

    ShoppingCartResponseDTO addProduct(String cartNumber, ShoppingCartRequestDTO shoppingCartRequestDTO) throws GenericShoppingCartError;
}
