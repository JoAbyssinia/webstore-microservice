package edu.miu.webshopclient.dto.shoppingcartQuery;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
@Data
public class ShoppingCartQueryResponseDTO {
    private String cartNumber;
    private List<ProductLine> productLines;
}
