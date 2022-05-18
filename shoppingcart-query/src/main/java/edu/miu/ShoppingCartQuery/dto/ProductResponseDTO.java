package edu.miu.ShoppingCartQuery.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDTO {
    private String productNumber;
    private String name;
    private Double price;
    private String description;
}
