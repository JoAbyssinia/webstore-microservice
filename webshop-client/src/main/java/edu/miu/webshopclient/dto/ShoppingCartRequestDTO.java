package edu.miu.webshopclient.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ShoppingCartRequestDTO {
    private String productNumber;
    private Integer quantity;
}
