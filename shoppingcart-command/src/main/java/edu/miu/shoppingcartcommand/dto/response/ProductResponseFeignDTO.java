package edu.miu.shoppingcartcommand.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseFeignDTO {
    private String productNumber;
    private String name;
    private Double price;
    private String description;
    private Integer quantity;
}
