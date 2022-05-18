package edu.miu.shoppingcartcommand.service.impl;

import edu.miu.shoppingcartcommand.dto.request.ShoppingCartRequestDTO;
import edu.miu.shoppingcartcommand.dto.response.ShoppingCartResponseDTO;
import edu.miu.shoppingcartcommand.entity.Product;
import edu.miu.shoppingcartcommand.feignClient.ProductInterface;
import edu.miu.shoppingcartcommand.repository.ShoppingCartRepository;
import edu.miu.shoppingcartcommand.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final ProductInterface productInterface;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository,
                                   ProductInterface productInterface) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.productInterface = productInterface;
    }

    @Override
    public ShoppingCartResponseDTO addCart(ShoppingCartRequestDTO shoppingCartRequestDTO) {
        Optional<ShoppingCartResponseDTO> product = Optional.ofNullable(
                productInterface.getProduct(
                        shoppingCartRequestDTO.getProductNumber()));
        if(product.isPresent()){
            System.out.println("I am here");
            return product.get();
        }
        System.out.println("I am not here");
        return null;
    }
}
