package edu.miu.shoppingcartcommand.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class ShoppingCart {
    private String cartNumber;
    private List<ProductLine> productLines;
}
