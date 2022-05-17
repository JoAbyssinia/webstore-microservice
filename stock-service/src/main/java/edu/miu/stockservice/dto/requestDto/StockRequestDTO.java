package edu.miu.stockservice.dto.requestDto;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
@Builder
public class StockRequestDTO {

    private String productNumber;
    private Integer quantity;
}
