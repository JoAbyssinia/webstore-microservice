package edu.miu.webshopclient.dto.shoppingcartcomponent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductLineResponseDTO {
    private ProductResponseDTO product;
    private int quantity;
}
