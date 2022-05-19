package edu.miu.webshopclient.dto.shoppingcartcomponent;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductRequestDTO {
    private String productNumber;
    private String name;
    private Double price;
    private String description;
}
