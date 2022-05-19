package edu.miu.orderservice.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductLineDTO {
    private ProductDTO product;
    private Integer quantity;
}
