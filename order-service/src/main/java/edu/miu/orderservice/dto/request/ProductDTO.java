package edu.miu.orderservice.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    private String productNumber;
    private String name;
    private String description;
    private Double price;
}
