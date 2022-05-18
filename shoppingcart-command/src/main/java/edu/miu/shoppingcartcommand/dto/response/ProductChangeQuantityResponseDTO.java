package edu.miu.shoppingcartcommand.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductChangeQuantityResponseDTO {
    private String cartNumber;
    private ProductResponseFeignDTO productResponseFeignDTO;
}
