package edu.miu.ShoppingCartQuery.dto;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductDTO {
    private String productNumber;
    private String name;
    private Double price;
    private String description;
}
