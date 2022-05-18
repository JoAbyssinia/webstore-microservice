package edu.miu.shoppingcartcommand.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private String productNumber;
    private String name;
    private String description;
    private Double price;
    private Integer quantity;
}
