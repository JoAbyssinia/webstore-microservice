package edu.miu.shoppingcartcommand.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ShoppingCartResponseDTO {
    private String cartNumber;
    private List<ProductLineResponseDTO> productLineResponseDTOList;
}
