package edu.miu.ShoppingCartQuery.util;

import edu.miu.ShoppingCartQuery.dto.request.ShoppingCartQueryRequestDTO;
import edu.miu.ShoppingCartQuery.dto.responce.ShoppingCartQueryResponseDTO;
import edu.miu.ShoppingCartQuery.entity.ShoppingCartQuery;


public class ShoppingCartQueryUtils {

    public static ShoppingCartQuery parseShoppingCartQueryRequestToShoppingCartQuery
            (ShoppingCartQueryRequestDTO shoppingCartQueryRequestDTO) {

        return new ShoppingCartQuery(null, shoppingCartQueryRequestDTO.getCartNumber(),
                shoppingCartQueryRequestDTO.getProductLines());
    }

    public static ShoppingCartQueryResponseDTO
    parseShoppingCartQueryToShoppingCartQueryResponseDTO(ShoppingCartQuery shoppingCartQuery) {
        return ShoppingCartQueryResponseDTO.builder()
                .cartNumber(shoppingCartQuery.getCartNumber())
                .productLines(shoppingCartQuery.getProductLines())
                .build();
    }
}
