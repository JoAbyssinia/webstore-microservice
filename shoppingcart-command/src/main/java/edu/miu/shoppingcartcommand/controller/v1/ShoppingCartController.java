package edu.miu.shoppingcartcommand.controller.v1;

import edu.miu.shoppingcartcommand.dto.request.ShoppingCartRequestDTO;
import edu.miu.shoppingcartcommand.dto.response.ShoppingCartResponseDTO;
import edu.miu.shoppingcartcommand.error.GenericShoppingCartError;
import edu.miu.shoppingcartcommand.service.ShoppingCartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;

@RestController
@RequestMapping("/api/v1/shopping-cart")
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }


    @PostMapping
    public ResponseEntity<?> addCart(@RequestBody ShoppingCartRequestDTO shoppingCartRequestDTO){
        try {
            ShoppingCartResponseDTO shoppingCartResponseDTO =
                    shoppingCartService.addCart(shoppingCartRequestDTO);
            if(shoppingCartResponseDTO!= null) {
                return new ResponseEntity<>(shoppingCartResponseDTO, HttpStatus.CREATED);
            }else{
                return new ResponseEntity<>(
                        getGenericShoppingCartError("The product with id : " + shoppingCartRequestDTO.getProductNumber() + " not found!"),
                        HttpStatus.NOT_FOUND);
            }
        }catch (GenericShoppingCartError ex){
            return new ResponseEntity<>(
                    ex.getMessage(),
                    HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{cartNumber}/add")
    public ResponseEntity<?> addProduct(@PathVariable String cartNumber,
                                        @RequestBody ShoppingCartRequestDTO shoppingCartRequestDTO){
        try {
            ShoppingCartResponseDTO shoppingCartResponseDTO =
                    shoppingCartService.addProduct(cartNumber, shoppingCartRequestDTO);
            if(shoppingCartResponseDTO!= null) {
                return new ResponseEntity<>(shoppingCartResponseDTO, HttpStatus.CREATED);
            }else{
                return new ResponseEntity<>(
                        getGenericShoppingCartError("The product with id : " + shoppingCartRequestDTO.getProductNumber() + " not found!"),
                        HttpStatus.NOT_FOUND);
            }
        }catch (GenericShoppingCartError ex){
            return new ResponseEntity<>(
                    ex.getMessage(),
                    HttpStatus.NOT_FOUND);
        }
    }

    public GenericShoppingCartError getGenericShoppingCartError(String message){
        return new GenericShoppingCartError(message);
    }

}