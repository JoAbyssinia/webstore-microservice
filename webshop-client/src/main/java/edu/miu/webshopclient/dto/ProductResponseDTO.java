package edu.miu.webshopclient.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

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
