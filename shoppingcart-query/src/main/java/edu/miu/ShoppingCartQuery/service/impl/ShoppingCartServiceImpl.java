package edu.miu.ShoppingCartQuery.service.impl;

import edu.miu.ShoppingCartQuery.dto.ProductDTO;
import edu.miu.ShoppingCartQuery.dto.request.ShoppingCartQueryRequestDTO;
import edu.miu.ShoppingCartQuery.dto.responce.ShoppingCartQueryResponseDTO;
import edu.miu.ShoppingCartQuery.entity.Product;
import edu.miu.ShoppingCartQuery.entity.ProductLine;
import edu.miu.ShoppingCartQuery.entity.ShoppingCartQuery;
import edu.miu.ShoppingCartQuery.repository.ShoppingCartQueryRepository;
import edu.miu.ShoppingCartQuery.service.ShoppingCartService;
import edu.miu.ShoppingCartQuery.util.ShoppingCartQueryUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartQueryRepository shoppingCartQueryRepository;

    public ShoppingCartServiceImpl(ShoppingCartQueryRepository shoppingCartQueryRepository) {
        this.shoppingCartQueryRepository = shoppingCartQueryRepository;
    }


    @Override
    public ShoppingCartQueryResponseDTO addShoppingCartQuery(ShoppingCartQueryRequestDTO shoppingCartQueryRequestDTO) {
        ShoppingCartQuery shoppingCartQuery =
                ShoppingCartQueryUtils.parseShoppingCartQueryRequestToShoppingCartQuery(shoppingCartQueryRequestDTO);
        shoppingCartQueryRepository.save(shoppingCartQuery);

        return ShoppingCartQueryUtils.parseShoppingCartQueryToShoppingCartQueryResponseDTO(shoppingCartQuery);
    }

    @Override
    public ShoppingCartQueryResponseDTO addProduct(String cartNumber, ProductDTO productDTO, Integer quantity) {

        Optional<ShoppingCartQuery> isFoundShoppingCartQuery = shoppingCartQueryRepository.findByCartNumber(cartNumber);

        if (isFoundShoppingCartQuery.isPresent()) {

            ShoppingCartQuery shoppingCartQuery = isFoundShoppingCartQuery.get();

            Product product = Product.builder()
                    .description(productDTO.getDescription())
                    .name(productDTO.getName())
                    .price(productDTO.getPrice())
                    .productNumber(productDTO.getProductNumber())
                    .build();
            ProductLine productLine = ProductLine.builder()
                    .product(product)
                    .quantity(quantity)
                    .build();
            shoppingCartQuery.getProductLines().add(productLine);

            shoppingCartQueryRepository.save(shoppingCartQuery);

            return ShoppingCartQueryUtils.parseShoppingCartQueryToShoppingCartQueryResponseDTO(shoppingCartQuery);
        }


        return null;
    }


    @Override
    public ShoppingCartQueryResponseDTO removeProduct(String cartNumber, ProductDTO productDTO) {

        Optional<ShoppingCartQuery> isFoundShoppingCartQuery = shoppingCartQueryRepository.findByCartNumber(cartNumber);

        if (isFoundShoppingCartQuery.isPresent()) {

            ShoppingCartQuery shoppingCartQuery = isFoundShoppingCartQuery.get();

            Product product = Product.builder()
                    .description(productDTO.getDescription())
                    .name(productDTO.getName())
                    .price(productDTO.getPrice())
                    .productNumber(productDTO.getProductNumber())
                    .build();

            shoppingCartQuery.getProductLines().forEach(productLine -> {
                if (productLine.getProduct().getProductNumber().equals(product.getProductNumber())) {
                    shoppingCartQuery.getProductLines().remove(productLine);
                    return;
                }
            });

            shoppingCartQueryRepository.save(shoppingCartQuery);

            return ShoppingCartQueryUtils.parseShoppingCartQueryToShoppingCartQueryResponseDTO(shoppingCartQuery);
        }

        return null;
    }

    @Override
    public ShoppingCartQueryResponseDTO changeProduct(String cartNumber, ProductDTO productDTO, Integer quantity) {

        Optional<ShoppingCartQuery> isFoundShoppingCartQuery = shoppingCartQueryRepository.findByCartNumber(cartNumber);

        if (isFoundShoppingCartQuery.isPresent()) {

            ShoppingCartQuery shoppingCartQuery = isFoundShoppingCartQuery.get();

            Product product = Product.builder()
                    .description(productDTO.getDescription())
                    .name(productDTO.getName())
                    .price(productDTO.getPrice())
                    .productNumber(productDTO.getProductNumber())
                    .build();

            shoppingCartQuery.getProductLines().stream().forEach(productLine -> {
                if (productLine.getProduct().equals(product)) {
                    productLine.setQuantity(quantity);

                }
            });
            shoppingCartQueryRepository.save(shoppingCartQuery);
            return ShoppingCartQueryUtils.parseShoppingCartQueryToShoppingCartQueryResponseDTO(shoppingCartQuery);
        }
        return null;
    }

    @Override
    public ShoppingCartQueryResponseDTO deleteShoppingCartQuery(String cartNumber) {
        Optional<ShoppingCartQuery> isFoundShoppingCartQuery =
                shoppingCartQueryRepository.findByCartNumber(cartNumber);

        if (isFoundShoppingCartQuery.isPresent()) {
            ShoppingCartQuery shoppingCartQuery = isFoundShoppingCartQuery.get();
            shoppingCartQueryRepository.delete(shoppingCartQuery);

            return ShoppingCartQueryUtils.parseShoppingCartQueryToShoppingCartQueryResponseDTO(shoppingCartQuery);
        }
        return null;
    }

    @Override
    public ShoppingCartQueryResponseDTO getShoppingCartQuery(String cartNumber) {
        Optional<ShoppingCartQuery> isFoundShoppingCartQuery =
                shoppingCartQueryRepository.findByCartNumber(cartNumber);

        if (isFoundShoppingCartQuery.isPresent()) {
            ShoppingCartQuery shoppingCartQuery = isFoundShoppingCartQuery.get();
            return ShoppingCartQueryUtils.parseShoppingCartQueryToShoppingCartQueryResponseDTO(shoppingCartQuery);
        }
        return null;
    }

    @Override
    public List<ShoppingCartQueryResponseDTO> getAllShoppingCartQuery() {
        List<ShoppingCartQueryResponseDTO> shoppingCartQueryResponseDTOS = new ArrayList<>();
        shoppingCartQueryRepository.findAll().forEach(shoppingCartQuery -> {
            shoppingCartQueryResponseDTOS.add(
                    ShoppingCartQueryUtils.parseShoppingCartQueryToShoppingCartQueryResponseDTO(shoppingCartQuery));

        });
        return shoppingCartQueryResponseDTOS;
    }
}
