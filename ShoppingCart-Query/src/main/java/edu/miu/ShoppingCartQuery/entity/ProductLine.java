package edu.miu.ShoppingCartQuery.entity;


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
