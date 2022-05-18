package edu.miu.shoppingcartcommand.service.impl;

import edu.miu.shoppingcartcommand.dto.request.ShoppingCartRequestDTO;
import edu.miu.shoppingcartcommand.dto.response.ProductResponseFeignDTO;
import edu.miu.shoppingcartcommand.dto.response.ShoppingCartResponseDTO;
import edu.miu.shoppingcartcommand.dto.response.StockResponseFeignDTO;
import edu.miu.shoppingcartcommand.entity.ProductLine;
import edu.miu.shoppingcartcommand.entity.ShoppingCart;
import edu.miu.shoppingcartcommand.error.GenericShoppingCartError;
import edu.miu.shoppingcartcommand.feignClient.ProductFeignInterface;
import edu.miu.shoppingcartcommand.feignClient.StockFeignInterface;
import edu.miu.shoppingcartcommand.repository.ShoppingCartRepository;
import edu.miu.shoppingcartcommand.service.ShoppingCartService;
import edu.miu.shoppingcartcommand.utils.ShoppingCartUtils;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.Random;

import static edu.miu.shoppingcartcommand.utils.ShoppingCartUtils.parseProductResponseFeignDTOToProductLine;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final ProductFeignInterface productFeignInterface;
    private final StockFeignInterface stockFeignInterface;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository,
                                   ProductFeignInterface productFeignInterface,
                                   StockFeignInterface stockFeignInterface) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.productFeignInterface = productFeignInterface;
        this.stockFeignInterface = stockFeignInterface;
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
            if(stockFeignResponse.get().getQuantity() >= shoppingCartRequestDTO.getQuantity()) {
                ProductLine productLine = parseProductResponseFeignDTOToProductLine(
                        productFeignResponse.get(), shoppingCartRequestDTO.getQuantity());
                shoppingCart.getProductLines().add(productLine);
                shoppingCart.setCartNumber(generateUniqueCartNumber());
                shoppingCart = shoppingCartRepository.save(shoppingCart);
                return ShoppingCartUtils.parseShoppingCartToShoppingCartResponseDTO(shoppingCart, shoppingCartRequestDTO.getQuantity());
            }else{
                throw new GenericShoppingCartError("The requested quantity is not available. Only " + stockFeignResponse.get().getQuantity() + "left!");
            }
        }else{
            return null;
        }
    }

    protected String generateUniqueCartNumber(){
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyMMddhhmmssMs");
        return generateRandomNumber() + ft.format(dNow);
    }

    public static String generateRandomNumber(){
        // It will generate 6 digit random Number.
        // from 0 to 999999
        Random rnd = new Random();
        int number = rnd.nextInt(999999);

        // this will convert any number sequence into 6 character.
        return String.format("%06d", number);
    }
}
