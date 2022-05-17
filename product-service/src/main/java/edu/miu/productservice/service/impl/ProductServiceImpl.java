package edu.miu.productservice.service.impl;

import edu.miu.productservice.dto.request.ProductRequestDTO;
import edu.miu.productservice.dto.response.ProductResponseDTO;
import edu.miu.productservice.entity.Product;
import edu.miu.productservice.repository.ProductRepository;
import edu.miu.productservice.service.ProductService;
import edu.miu.productservice.util.ProductUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {


    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }


    @Override
    public ProductResponseDTO addProduct(ProductRequestDTO productRequestDto) {
        ProductUtil util = new ProductUtil();
        Product product = util.parseProductRequestDTOToProduct(productRequestDto);
        repository.save(product);
        return util.parseProductTOProductResponseDTO(product);
    }

    @Override
    public ProductResponseDTO updateProduct(String productNumber, ProductRequestDTO productRequestDto) {

        Optional<Product> found = repository.findByProductNumber(productNumber);
        if (found.isPresent()) {
            Product product = found.get();
            product.setDescription(productRequestDto.getDescription());
            product.setName(productRequestDto.getName());
            product.setPrice(productRequestDto.getPrice());
            repository.save(product);


            return new ProductUtil().parseProductTOProductResponseDTO(product);
        }
        return null;

    }

    @Override
    public ProductResponseDTO deleteProduct(String productNumber) {
        Optional<Product> found = repository.findByProductNumber(productNumber);
        found.ifPresent(repository::delete);
        ProductUtil util = new ProductUtil();
        return util.parseProductTOProductResponseDTO(found.get());
    }

    @Override
    public List<ProductResponseDTO> getAllProduct() {
        List<ProductResponseDTO> productResponseDTOS = new ArrayList<>();

        repository.findAll().stream().forEach(n -> {

            productResponseDTOS.add(
                    ProductResponseDTO.builder()
                            .productNumber(n.getProductNumber())
                            .name(n.getName())
                            .price(n.getPrice())
                            .description(n.getDescription())
                            .build());
        });

        return productResponseDTOS;
    }

    @Override
    public ProductResponseDTO getProduct(String productNumber) {
        Optional<Product> found = repository.findByProductNumber(productNumber);
        if (found.isPresent()) {
            ProductUtil util = new ProductUtil();
            return util.parseProductTOProductResponseDTO(found.get());
        }
        return null;
    }
}
