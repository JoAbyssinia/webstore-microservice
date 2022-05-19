package edu.miu.webshopclient.dto.shoppingcartQuery;


import edu.miu.webshopclient.entity.Product;
import lombok.*;


@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductLine {
    private Product product;
    private Integer quantity;
}
