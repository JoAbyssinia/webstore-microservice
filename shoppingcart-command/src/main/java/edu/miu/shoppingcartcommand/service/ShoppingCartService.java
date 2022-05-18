package edu.miu.shoppingcartcommand.service;

import edu.miu.shoppingcartcommand.dto.request.ShoppingCartRequestDTO;
import edu.miu.shoppingcartcommand.dto.response.ShoppingCartResponseDTO;

public interface ShoppingCartService {
    ShoppingCartResponseDTO addCart(ShoppingCartRequestDTO shoppingCartRequestDTO);
}
