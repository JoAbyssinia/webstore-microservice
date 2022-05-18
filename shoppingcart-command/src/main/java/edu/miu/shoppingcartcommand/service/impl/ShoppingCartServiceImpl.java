package edu.miu.shoppingcartcommand.service.impl;

import edu.miu.shoppingcartcommand.dto.request.ProductChangeQuantityRequestDTO;
import edu.miu.shoppingcartcommand.dto.request.ProductRequestDTO;
import edu.miu.shoppingcartcommand.dto.request.ShoppingCartRequestDTO;
import edu.miu.shoppingcartcommand.dto.response.*;
import edu.miu.shoppingcartcommand.entity.ProductLine;
import edu.miu.shoppingcartcommand.entity.ShoppingCart;
import edu.miu.shoppingcartcommand.error.GenericShoppingCartError;
import edu.miu.shoppingcartcommand.feignClient.ProductFeignInterface;
import edu.miu.shoppingcartcommand.feignClient.StockFeignInterface;
import edu.miu.shoppingcartcommand.integration.KafkaMessage;
import edu.miu.shoppingcartcommand.repository.ShoppingCartRepository;
import edu.miu.shoppingcartcommand.service.ShoppingCartService;
import edu.miu.shoppingcartcommand.utils.ShoppingCartUtils;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;


import static edu.miu.shoppingcartcommand.utils.ShoppingCartUtils.parseProductResponseFeignDTOToProductLine;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final ProductFeignInterface productFeignInterface;
    private final StockFeignInterface stockFeignInterface;

    private final KafkaMessage kafkaMessage;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository,
                                   ProductFeignInterface productFeignInterface,
                                   StockFeignInterface stockFeignInterface,
                                   KafkaMessage kafkaMessage) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.productFeignInterface = productFeignInterface;
        this.stockFeignInterface = stockFeignInterface;
        this.kafkaMessage = kafkaMessage;
    }

    @Override
    public ShoppingCartResponseDTO addCart(ShoppingCartRequestDTO shoppingCartRequestDTO) throws GenericShoppingCartError {
        ShoppingCart shoppingCart = new ShoppingCart();
        Optional<ProductResponseFeignDTO> productFeignResponse = Optional.ofNullable(
                productFeignInterface.getProduct(
                        shoppingCartRequestDTO.getProductNumber()));
        if (productFeignResponse.isPresent()) {
            Optional<StockResponseFeignDTO> stockFeignResponse = Optional.ofNullable(
                    stockFeignInterface.getStock(shoppingCartRequestDTO.getProductNumber()));
            if (stockFeignResponse.get().getQuantity() >= shoppingCartRequestDTO.getQuantity()) {
                ProductLine productLine = parseProductResponseFeignDTOToProductLine(
                        productFeignResponse.get(), shoppingCartRequestDTO.getQuantity());
                shoppingCart.getProductLines().add(productLine);
                shoppingCart.setCartNumber(generateUniqueCartNumber());
                shoppingCart = shoppingCartRepository.save(shoppingCart);

                ShoppingCartResponseDTO shoppingCartResponseDTO =
                        ShoppingCartUtils.parseShoppingCartToShoppingCartResponseDTO(shoppingCart,
                        shoppingCartRequestDTO.getQuantity());
                kafkaMessage.sendMessage("create-cart", shoppingCartResponseDTO);

                return shoppingCartResponseDTO;
            } else {
                throw new GenericShoppingCartError("The requested quantity is not available. Only " +
                        stockFeignResponse.get().getQuantity() + " left!");
            }
        } else {
            return null;
        }
    }

    @Override
    public ShoppingCartResponseDTO addProduct(String cartNumber,
                                              ShoppingCartRequestDTO shoppingCartRequestDTO)
            throws GenericShoppingCartError {
        Optional<ShoppingCart> isShoppingCartExist = shoppingCartRepository.findByCartNumber(cartNumber);
        if (isShoppingCartExist.isEmpty()) {
            throw new GenericShoppingCartError("Shopping Cart Not Available!");
        }
        Optional<ProductResponseFeignDTO> productFeignResponse = Optional.ofNullable(
                productFeignInterface.getProduct(
                        shoppingCartRequestDTO.getProductNumber()));
        if (productFeignResponse.isPresent()) {
            Optional<StockResponseFeignDTO> stockFeignResponse = Optional.ofNullable(
                    stockFeignInterface.getStock(shoppingCartRequestDTO.getProductNumber()));
            if (stockFeignResponse.get().getQuantity() >= shoppingCartRequestDTO.getQuantity()) {
                ProductLine productLine = parseProductResponseFeignDTOToProductLine(
                        productFeignResponse.get(), shoppingCartRequestDTO.getQuantity());
                isShoppingCartExist.get().getProductLines().add(productLine);
                shoppingCartRepository.save(isShoppingCartExist.get());
                return ShoppingCartUtils.parseShoppingCartToShoppingCartResponseDTO(isShoppingCartExist.get(),
                        shoppingCartRequestDTO.getQuantity());
            } else {
                throw new GenericShoppingCartError("The requested quantity is not available. Only " +
                        stockFeignResponse.get().getQuantity() + "left!");
            }
        } else {
            throw new GenericShoppingCartError("Product with id: " + shoppingCartRequestDTO.getProductNumber() + " does not exist!");
        }
    }

    public ProductResponseDTO removeProduct(String cartNumber, ProductRequestDTO productRequestDTO) throws GenericShoppingCartError {
        boolean found = false;
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
                Optional<ShoppingCart> isShoppingCartExist = shoppingCartRepository.findByCartNumber(cartNumber);
        if (isShoppingCartExist.isEmpty()) {
            throw new GenericShoppingCartError("Shopping Cart Not Available!");
        }
        List<ProductLine> productLineList = isShoppingCartExist.get().getProductLines();
        for (ProductLine productLine : productLineList) {
            if (productLine.getProduct().getProductNumber().equals(productRequestDTO.getProductNumber())) {
                found = true;
                productResponseDTO = new ProductResponseDTO(productLine.getProduct().getProductNumber(),
                        productLine.getProduct().getName(), productLine.getProduct().getPrice(), productLine.getProduct().getDescription());
                productLineList.remove(productLine);
                break;
            }
        }
        if (found){
            shoppingCartRepository.save(isShoppingCartExist.get());
            return productResponseDTO;
        }else{
            throw new GenericShoppingCartError("Product with id: " + productRequestDTO.getProductNumber() + " not found!");
        }
    }

    public ProductChangeQuantityResponseDTO changeQuantity(String cartNumber, ProductChangeQuantityRequestDTO
            productChangeQuantityRequestDTO) throws GenericShoppingCartError {
        ProductChangeQuantityResponseDTO productChangeQuantityResponseDTO = new ProductChangeQuantityResponseDTO();
        ProductResponseFeignDTO productResponseFeignDTO = new ProductResponseFeignDTO();

        Optional<ShoppingCart> isShoppingCartExist = shoppingCartRepository.findByCartNumber(cartNumber);
        if (isShoppingCartExist.isEmpty()) {
            throw new GenericShoppingCartError("Shopping Cart Not Available!");
        }

        Optional<ProductResponseFeignDTO> productFeignResponse = Optional.ofNullable(
                productFeignInterface.getProduct(
                        productChangeQuantityRequestDTO.getProductNumber()));

        if(productFeignResponse.isPresent()) {
            List<ProductLine> productLineList = isShoppingCartExist.get().getProductLines();
            for(ProductLine productLine: productLineList){
                if (productLine.getProduct().getProductNumber().equals(productChangeQuantityRequestDTO.getProductNumber())){
                    Optional<StockResponseFeignDTO> stockFeignResponse = Optional.ofNullable(
                            stockFeignInterface.getStock(productChangeQuantityRequestDTO.getProductNumber()));
                    if (stockFeignResponse.get().getQuantity() >= productChangeQuantityRequestDTO.getQuantity()) {
                        productLine.setQuantity(productChangeQuantityRequestDTO.getQuantity());
                        productResponseFeignDTO = ProductResponseFeignDTO.builder().productNumber(productLine.getProduct().getProductNumber())
                                .name(productLine.getProduct().getName())
                                .price(productLine.getProduct().getPrice())
                                .description(productLine.getProduct().getDescription())
                                .quantity(productLine.getQuantity())
                                .build();
                        shoppingCartRepository.save(isShoppingCartExist.get());
                    }else {
                        try {
                            throw new GenericShoppingCartError("The requested quantity is not available. Only " +
                                    stockFeignResponse.get().getQuantity() + "left!");
                        } catch (GenericShoppingCartError e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                }
            }
              productChangeQuantityResponseDTO.setCartNumber(cartNumber);
              productChangeQuantityResponseDTO.setProductResponseFeignDTO(productResponseFeignDTO);
                return productChangeQuantityResponseDTO;
            }else{
            throw new GenericShoppingCartError("Product with id: " + productChangeQuantityRequestDTO.getProductNumber() + " not found!");
        }
    }


    protected String generateUniqueCartNumber() {
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyMMddhhmmssMs");
        return generateRandomNumber() + ft.format(dNow);
    }

    public static String generateRandomNumber() {
        // It will generate 6 digit random Number.
        // from 0 to 999999
        Random rnd = new Random();
        int number = rnd.nextInt(999999);

        // this will convert any number sequence into 6 character.
        return String.format("%06d", number);
    }
}
