/**
 *
 */
package edu.miu.ShoppingCartQuery.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    private String productNumber;
    private String name;
    private Double price;
    private String description;

}