package edu.miu.ShoppingCartQuery.entity.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    private BigInteger id;
    private String orderNumber;
    private Date orderDate;
    private List<OrderLine> orderLine;
    private String customerID;
    private Character orderStatus;

}
