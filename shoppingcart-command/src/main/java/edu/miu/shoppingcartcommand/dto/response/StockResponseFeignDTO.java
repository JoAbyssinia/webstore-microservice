package edu.miu.shoppingcartcommand.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockResponseFeignDTO {
    private String productNumber;
    private Integer quantity;
}
