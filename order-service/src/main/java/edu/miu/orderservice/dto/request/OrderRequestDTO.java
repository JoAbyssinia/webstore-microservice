package edu.miu.orderservice.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequestDTO {
    private ShoppingCartRequestDTO shoppingCart;
    private String customerID;
}
