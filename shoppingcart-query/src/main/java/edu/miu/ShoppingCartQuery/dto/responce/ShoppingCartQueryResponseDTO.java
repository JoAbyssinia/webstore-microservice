package edu.miu.ShoppingCartQuery.dto.responce;

import edu.miu.ShoppingCartQuery.entity.ProductLine;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class ShoppingCartQueryResponseDTO {
    private String cartNumber;
    private List<ProductLine> productLines;
}
