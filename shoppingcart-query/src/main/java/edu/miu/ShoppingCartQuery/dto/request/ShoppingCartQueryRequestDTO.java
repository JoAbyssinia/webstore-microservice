package edu.miu.ShoppingCartQuery.dto.request;

import edu.miu.ShoppingCartQuery.entity.ProductLine;
import lombok.*;

import java.util.List;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class ShoppingCartQueryRequestDTO {
    private String cartNumber;
    private List<ProductLine> productLines;
}
