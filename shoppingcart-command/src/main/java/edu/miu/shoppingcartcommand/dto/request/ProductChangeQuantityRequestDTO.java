package edu.miu.shoppingcartcommand.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductChangeQuantityRequestDTO {
    private String productNumber;
    private Integer quantity;
}
