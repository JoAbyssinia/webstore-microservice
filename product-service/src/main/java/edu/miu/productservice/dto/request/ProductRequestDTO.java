package edu.miu.productservice.dto.request;


import lombok.*;

import java.io.Serializable;

@Getter
@Builder
public class ProductRequestDTO implements Serializable {

    private String productNumber;
    private String name;
    private double price;
    private String description;

}
