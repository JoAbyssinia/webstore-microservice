package edu.miu.orderservice.entity;

import edu.miu.orderservice.dto.request.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderLine {
    private ProductDTO product;
    private Integer quantity;
}
