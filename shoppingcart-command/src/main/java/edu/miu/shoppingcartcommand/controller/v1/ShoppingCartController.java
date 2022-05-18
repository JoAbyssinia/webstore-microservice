package edu.miu.shoppingcartcommand.controller.v1;

import edu.miu.shoppingcartcommand.dto.request.ShoppingCartRequestDTO;
import edu.miu.shoppingcartcommand.dto.response.ShoppingCartResponseDTO;
import edu.miu.shoppingcartcommand.service.ShoppingCartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/shopping-cart")
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }


    @PostMapping
    public ResponseEntity<?> addCart(@RequestBody ShoppingCartRequestDTO shoppingCartRequestDTO){
        ShoppingCartResponseDTO shoppingCartResponseDTO =
                shoppingCartService.addCart(shoppingCartRequestDTO);
        return new ResponseEntity<>(shoppingCartResponseDTO, HttpStatus.CREATED);
    }

}
