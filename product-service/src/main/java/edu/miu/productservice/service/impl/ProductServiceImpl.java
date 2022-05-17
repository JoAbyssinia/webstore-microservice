package edu.miu.productservice.service.impl;

import edu.miu.productservice.dto.request.ProductRequestDTO;
import edu.miu.productservice.dto.request.StockRequestDTO;
import edu.miu.productservice.dto.response.ProductResponseDTO;
import edu.miu.productservice.dto.response.StockResponseDTO;
import edu.miu.productservice.entity.Product;
import edu.miu.productservice.feignClient.StockInterface;
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

    private final StockInterface stockInterface;

    public ProductServiceImpl(ProductRepository productRepository, StockInterface stockInterface) {
        this.productRepository = productRepository;
        this.stockInterface = stockInterface;
    }


    @Override
    public ProductResponseDTO addProduct(ProductRequestDTO productRequestDto) {

        Product product = ProductUtils.parseProductRequestDTOToProduct(productRequestDto);

        productRepository.save(product);

        StockRequestDTO stockRequestDTO = StockRequestDTO.builder()
                .productNumber(productRequestDto.getProductNumber())
                .quantity(productRequestDto.getQuantity()).build();
        stockInterface.addStock(stockRequestDTO);
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
        stockInterface.deleteStock(productNumber);
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

        if (isProductFound.isPresent()) {
            Product product = isProductFound.get();
            StockResponseDTO stockResponseDTO = stockInterface.getStock(productNumber);

            return ProductResponseDTO.builder()
                    .productNumber(product.getProductNumber())
                    .description(product.getDescription())
                    .name(product.getName())
                    .price(product.getPrice())
                    .quantity(stockResponseDTO.getQuantity())
                    .build();
        }
        return null;
    }
}
