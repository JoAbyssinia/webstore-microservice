package edu.miu.ShoppingCartQuery.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.util.List;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCartQuery {
    @Id
    private BigInteger id;
    private String cartNumber;
    private List<ProductLine> productLines;
}
