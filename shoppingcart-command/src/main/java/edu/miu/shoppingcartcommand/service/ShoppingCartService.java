package edu.miu.shoppingcartcommand.service;

import edu.miu.shoppingcartcommand.dto.request.ProductChangeQuantityRequestDTO;
import edu.miu.shoppingcartcommand.dto.request.ProductRequestDTO;
import edu.miu.shoppingcartcommand.dto.request.ShoppingCartRequestDTO;
import edu.miu.shoppingcartcommand.dto.response.ProductChangeQuantityResponseDTO;
import edu.miu.shoppingcartcommand.dto.response.ProductResponseDTO;
import edu.miu.shoppingcartcommand.dto.response.ShoppingCartResponseDTO;
import edu.miu.shoppingcartcommand.error.GenericShoppingCartError;

public interface ShoppingCartService {
    ShoppingCartResponseDTO addCart(ShoppingCartRequestDTO shoppingCartRequestDTO) throws GenericShoppingCartError;

    ShoppingCartResponseDTO addProduct(String cartNumber, ShoppingCartRequestDTO shoppingCartRequestDTO) throws GenericShoppingCartError;

    ProductResponseDTO removeProduct(String cartNumber, ProductRequestDTO productRequestDTO) throws GenericShoppingCartError;

    ProductChangeQuantityResponseDTO changeQuantity(String cartNumber, ProductChangeQuantityRequestDTO
            productChangeQuantityRequestDTO) throws GenericShoppingCartError;
}
