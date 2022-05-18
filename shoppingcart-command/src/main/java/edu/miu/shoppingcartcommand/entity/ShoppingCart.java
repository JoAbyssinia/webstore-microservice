package edu.miu.shoppingcartcommand.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Document
@Data
public class ShoppingCart {
    @Id
    private BigInteger id;
    private String cartNumber;
    private List<ProductLine> productLines;

    public ShoppingCart(){
        productLines = new ArrayList<>();
    }
}
