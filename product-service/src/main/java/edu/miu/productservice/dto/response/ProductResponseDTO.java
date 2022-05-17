package edu.miu.productservice.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@Builder
public class ProductResponseDTO implements Serializable {

    private String productNumber;
    private String name;
    private double price;
    private String description;

}
