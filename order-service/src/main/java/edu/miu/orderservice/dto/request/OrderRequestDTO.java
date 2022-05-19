package edu.miu.orderservice.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequestDTO {
    private String customerID;
    private ShoppingCartRequestDTO shoppingCart;
}
