package edu.miu.shoppingcartcommand.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.util.List;

@Document
@Data
public class ShoppingCart {
    @Id
    private BigInteger id;
    private String cartNumber;
    private List<ProductLine> productLines;
}
