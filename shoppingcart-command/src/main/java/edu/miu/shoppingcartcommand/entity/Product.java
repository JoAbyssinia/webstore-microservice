package edu.miu.shoppingcartcommand.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private String productNumber;
    private String name;
    private Double price;
    private String description;
}
