package edu.miu.ShoppingCartQuery.dto.request;

import edu.miu.ShoppingCartQuery.entity.ProductLine;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class ShoppingCartQueryRequestDTO {
    private String cartNumber;
    private List<ProductLine> productLines;
}
