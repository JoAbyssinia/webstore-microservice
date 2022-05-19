package edu.miu.ShoppingCartQuery.service.impl;

import edu.miu.ShoppingCartQuery.dto.request.ProductDTO;
import edu.miu.ShoppingCartQuery.dto.request.OrderRequestDTO;
import edu.miu.ShoppingCartQuery.dto.request.ProductLineDTO;
import edu.miu.ShoppingCartQuery.dto.request.ShoppingCartQueryRequestDTO;
import edu.miu.ShoppingCartQuery.dto.request.ShoppingCartRequestDTO;
import edu.miu.ShoppingCartQuery.dto.responce.ShoppingCartQueryResponseDTO;
import edu.miu.ShoppingCartQuery.entity.Product;
import edu.miu.ShoppingCartQuery.entity.ProductLine;
import edu.miu.ShoppingCartQuery.entity.ShoppingCartQuery;
import edu.miu.ShoppingCartQuery.feignClient.OrderFeignInterface;
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
    private final OrderFeignInterface orderFeignInterface;

    public ShoppingCartServiceImpl(ShoppingCartQueryRepository shoppingCartQueryRepository, OrderFeignInterface orderFeignInterface) {
        this.shoppingCartQueryRepository = shoppingCartQueryRepository;
        this.orderFeignInterface = orderFeignInterface;
    }


    @Override
    public ShoppingCartQueryResponseDTO addShoppingCartQuery(ShoppingCartQueryRequestDTO shoppingCartQueryRequestDTO) {
        ShoppingCartQuery shoppingCartQuery =
                ShoppingCartQueryUtils.parseShoppingCartQueryRequestToShoppingCartQuery(shoppingCartQueryRequestDTO);
        shoppingCartQueryRepository.save(shoppingCartQuery);

        return ShoppingCartQueryUtils.parseShoppingCartQueryToShoppingCartQueryResponseDTO(shoppingCartQuery);
    }

    @Override
    public ShoppingCartQueryResponseDTO addProduct(ShoppingCartQueryRequestDTO shoppingCartQueryRequestDTO) {

        Optional<ShoppingCartQuery> isFoundShoppingCartQuery =
                shoppingCartQueryRepository.findByCartNumber(shoppingCartQueryRequestDTO.getCartNumber());

        if (isFoundShoppingCartQuery.isPresent()) {

//            ShoppingCartQuery shoppingCartQuery = isFoundShoppingCartQuery.get();

            ShoppingCartQuery shoppingCartQuery = new ShoppingCartQuery();
            shoppingCartQuery.setId(null);
            shoppingCartQuery.setCartNumber(shoppingCartQueryRequestDTO.getCartNumber());

            List<ProductLine> productLines = new ArrayList<>();
            shoppingCartQueryRequestDTO.getProductLines().forEach(productLine -> {
                ProductLine line = new ProductLine();
                line.setProduct(productLine.getProduct());
                line.setQuantity(productLine.getQuantity());
                productLines.add(line);
            });
            shoppingCartQuery.setProductLines(productLines);
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

    @Override
    public String getShoppingCartQueryCheckout(String cartNumber, String customerId) {
        Optional<ShoppingCartQuery> isFoundShoppingCartQuery =
                shoppingCartQueryRepository.findByCartNumber(cartNumber);

        if (isFoundShoppingCartQuery.isPresent()) {

            ShoppingCartQuery shoppingCartQuery = isFoundShoppingCartQuery.get();

//            create order request
            OrderRequestDTO orderRequestDTO = new OrderRequestDTO();
//            add customer ID
            orderRequestDTO.setCustomerID(customerId);

            List<ProductLineDTO> productLines = new ArrayList<>();
            shoppingCartQuery.getProductLines().forEach(productLine -> {

                ProductLineDTO line = new ProductLineDTO();

                ProductDTO productDTO = ProductDTO.builder()
                        .description(productLine.getProduct().getDescription())
                        .name(productLine.getProduct().getName())
                        .price(productLine.getProduct().getPrice())
                        .productNumber(productLine.getProduct().getProductNumber())
                        .build();
                line.setProduct(productDTO);
                line.setQuantity(productLine.getQuantity());

            productLines.add(line);

            });

            ShoppingCartRequestDTO shoppingCartRequestDTO = new ShoppingCartRequestDTO();
            shoppingCartRequestDTO.setProductLines(productLines);
            shoppingCartRequestDTO.setCartNumber(shoppingCartQuery.getCartNumber());


            orderRequestDTO.setShoppingCart(shoppingCartRequestDTO);

            orderFeignInterface.checkout(orderRequestDTO);

        }
        return null;
    }
}
