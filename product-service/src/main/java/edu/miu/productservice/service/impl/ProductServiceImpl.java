package edu.miu.productservice.service.impl;

import edu.miu.productservice.dto.request.ProductRequestDTO;
import edu.miu.productservice.dto.response.ProductResponseDTO;
import edu.miu.productservice.entity.Product;
import edu.miu.productservice.repository.ProductRepository;
import edu.miu.productservice.service.ProductService;
import edu.miu.productservice.util.ProductUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {


    private final ProductRepository productRepository;
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public ProductResponseDTO addProduct(ProductRequestDTO productRequestDto) {
        Product product = ProductUtils.parseProductRequestDTOToProduct(productRequestDto);
        productRepository.save(product);
        return ProductUtils.parseProductTOProductResponseDTO(product);
    }

    @Override
    public ProductResponseDTO updateProduct(String productNumber, ProductRequestDTO productRequestDto) {
        Optional<Product> isProductExist = productRepository.findByProductNumber(productNumber);
        if (isProductExist.isPresent()) {
            Product product = isProductExist.get();
            product.setDescription(productRequestDto.getDescription());
            product.setName(productRequestDto.getName());
            product.setPrice(productRequestDto.getPrice());
            productRepository.save(product);
            return ProductUtils.parseProductTOProductResponseDTO(product);
        }
        return null;

    }

    @Override
    public ProductResponseDTO deleteProduct(String productNumber) {
        Optional<Product> isProductExist = productRepository.findByProductNumber(productNumber);
        isProductExist.ifPresent(productRepository::delete);
        return ProductUtils.parseProductTOProductResponseDTO(isProductExist.get());
    }

    @Override
    public List<ProductResponseDTO> getAllProduct() {
        List<ProductResponseDTO> productResponseDTOS = new ArrayList<>();
        productRepository.findAll().forEach(product -> {
            productResponseDTOS.add(
                    ProductResponseDTO.builder()
                            .productNumber(product.getProductNumber())
                            .name(product.getName())
                            .price(product.getPrice())
                            .description(product.getDescription())
                            .build());
        });

        return productResponseDTOS;
    }

    @Override
    public ProductResponseDTO getProduct(String productNumber) {
        Optional<Product> isProductFound = productRepository.findByProductNumber(productNumber);
        return isProductFound.map(ProductUtils::parseProductTOProductResponseDTO).orElse(null);
    }
}
