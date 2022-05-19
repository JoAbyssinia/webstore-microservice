package edu.miu.stockservice.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stock {

    @Id
    private BigInteger id;
    private String productNumber;
    private Integer quantity;

    public void decrementQuantity(int count) {
        this.quantity = quantity - count;
    }

}
