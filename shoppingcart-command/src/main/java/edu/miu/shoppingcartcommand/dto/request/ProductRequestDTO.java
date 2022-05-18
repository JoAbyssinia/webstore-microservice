package edu.miu.shoppingcartcommand.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDTO {
    private String productNumber;
    private String name;
    private Double price;
    private String description;
}
