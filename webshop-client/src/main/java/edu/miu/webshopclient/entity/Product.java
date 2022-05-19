package edu.miu.webshopclient.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class Product {
    private String productNumber;
    private String name;
    private Double price;
    private String description;
    private Integer quantity;
}
