package edu.miu.webshopclient.dto.shoppingcartcomponent;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShoppingCartRequestDTO {
    private String productNumber;
    private Integer quantity;
}
