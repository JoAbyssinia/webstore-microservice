package edu.miu.ShoppingCartQuery.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ShoppingCartRequestDTO {
    private String cartNumber;
    private List<ProductLineDTO> productLines;
}
