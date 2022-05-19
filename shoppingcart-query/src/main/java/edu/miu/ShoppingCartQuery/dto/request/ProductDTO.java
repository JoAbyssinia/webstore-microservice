package edu.miu.ShoppingCartQuery.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductDTO {
    private String productNumber;
    private String name;
    private String description;
    private Double price;
}
