package edu.miu.orderservice.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private String productNumber;
    private String description;
    private Double price;
}
