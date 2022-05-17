package edu.miu.stockservice.dto.responceDto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class StockResponseDTO {
    private String productNumber;
    private Integer quantity;
}
