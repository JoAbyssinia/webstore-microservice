package edu.miu.productservice.service;


import edu.miu.productservice.dto.ProductDto;
import edu.miu.productservice.entity.Product;

import java.util.List;

public interface ProductService {

     ProductDto addProduct(ProductDto productDto);
     ProductDto updateProduct(Integer productNumber, ProductDto productDto);
     void deleteProduct(Integer productNumber);
     List<ProductDto> getAllProduct();
     ProductDto getProduct(Integer productNumber);


}
