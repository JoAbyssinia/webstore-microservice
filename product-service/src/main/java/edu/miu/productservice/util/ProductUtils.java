package edu.miu.productservice.util;

import edu.miu.productservice.dto.request.ProductRequestDTO;
import edu.miu.productservice.dto.response.ProductResponseDTO;
import edu.miu.productservice.entity.Product;
import org.springframework.stereotype.Component;


public class ProductUtils {

    public static Product parseProductRequestDTOToProduct(ProductRequestDTO productRequestDto) {
        return new Product(null,
                productRequestDto.getProductNumber(),
                productRequestDto.getName(),
                productRequestDto.getPrice(),
                productRequestDto.getDescription());
    }

    public static ProductResponseDTO parseProductTOProductResponseDTO(Product product) {

        return ProductResponseDTO.builder()
                .productNumber(product.getProductNumber())
                .name(product.getName())
                .description(product.getDescription())
                .build();
    }

}
