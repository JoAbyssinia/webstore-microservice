package edu.miu.shoppingcartcommand.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponseFeignDTO {
    private String productNumber;
    private String name;
    private Double price;
    private String description;
    private Integer quantity;
}
