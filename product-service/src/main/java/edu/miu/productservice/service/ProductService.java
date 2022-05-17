package edu.miu.productservice.service;


import edu.miu.productservice.dto.request.ProductRequestDTO;
import edu.miu.productservice.dto.response.ProductResponseDTO;

import java.util.List;

public interface ProductService {

    ProductResponseDTO addProduct(ProductRequestDTO productRequestDto);

    ProductResponseDTO updateProduct(String productNumber, ProductRequestDTO productRequestDto);

    ProductResponseDTO deleteProduct(String productNumber);

    List<ProductResponseDTO> getAllProduct();

    ProductResponseDTO getProduct(String productNumber);


}
