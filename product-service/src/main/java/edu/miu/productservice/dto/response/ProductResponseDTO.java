package edu.miu.productservice.dto.response;


import lombok.*;

import java.io.Serializable;

@Getter
@Builder
@Data
public class ProductResponseDTO implements Serializable {

    private String productNumber;
    private String name;
    private double price;
    private String description;
    private Integer quantity;
}
