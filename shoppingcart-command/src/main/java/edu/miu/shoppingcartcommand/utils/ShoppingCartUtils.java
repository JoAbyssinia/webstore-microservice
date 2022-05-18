package edu.miu.shoppingcartcommand.utils;

import edu.miu.shoppingcartcommand.dto.response.ProductLineResponseDTO;
import edu.miu.shoppingcartcommand.dto.response.ProductResponseDTO;
import edu.miu.shoppingcartcommand.dto.response.ProductResponseFeignDTO;
import edu.miu.shoppingcartcommand.dto.response.ShoppingCartResponseDTO;
import edu.miu.shoppingcartcommand.entity.Product;
import edu.miu.shoppingcartcommand.entity.ProductLine;
import edu.miu.shoppingcartcommand.entity.ShoppingCart;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartUtils {

    public static ProductLine parseProductResponseFeignDTOToProductLine(
            ProductResponseFeignDTO productResponseFeignDTO, Integer requestedQuantity) {
        Product product = new Product(productResponseFeignDTO.getProductNumber(),
                productResponseFeignDTO.getName(),
                productResponseFeignDTO.getPrice(),
                productResponseFeignDTO.getDescription());
        ProductLine productLine = new ProductLine(product,requestedQuantity );
        return productLine;
    }

    public static ShoppingCartResponseDTO parseShoppingCartToShoppingCartResponseDTO(ShoppingCart shoppingCart, Integer requestedQuantity){
        ShoppingCartResponseDTO shoppingCartResponseDTO = new ShoppingCartResponseDTO();
        shoppingCartResponseDTO.setCartNumber(shoppingCart.getCartNumber());
        List<ProductLineResponseDTO> productLineResponseDTOS = new ArrayList<>();
        for (ProductLine productLine :
                shoppingCart.getProductLines()) {
            ProductLineResponseDTO productLineResponseDTO = new ProductLineResponseDTO();
            ProductResponseDTO productResponseDTO = new ProductResponseDTO();
            productResponseDTO.setProductNumber(productLine.getProduct().getProductNumber());
            productResponseDTO.setName(productLine.getProduct().getName());
            productResponseDTO.setPrice(productLine.getProduct().getPrice());
            productResponseDTO.setDescription(productLine.getProduct().getDescription());
            productLineResponseDTO.setProduct(productResponseDTO);
            productLineResponseDTO.setQuantity(requestedQuantity);
            productLineResponseDTOS.add(productLineResponseDTO);
        }
        shoppingCartResponseDTO.setProductLineResponseDTOList(productLineResponseDTOS);
        return shoppingCartResponseDTO;
    }
}
