package edu.miu.productservice.dto.request;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class StockRequestDTO {

    private String productNumber;
    private Integer quantity;
}
