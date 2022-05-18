package edu.miu.shoppingcartcommand.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShoppingCartRequestDTO {
    private String productNumber;
    private Integer quantity;
}
