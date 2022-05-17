package edu.miu.productservice.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class StockResponseDTO {
    private String productNumber;
    private Integer quantity;
}
