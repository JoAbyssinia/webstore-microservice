package edu.miu.ShoppingCartQuery.controller.v1;


import edu.miu.ShoppingCartQuery.dto.responce.ShoppingCartQueryResponseDTO;
import edu.miu.ShoppingCartQuery.entity.order.Order;
import edu.miu.ShoppingCartQuery.service.ShoppingCartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/shopping-cart-query")
public class ShoppingCartQueryController {

    private final ShoppingCartService shoppingCartService;

    public ShoppingCartQueryController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping("/{cartNumber}")
    ResponseEntity<?> getShoppingCart(@PathVariable String cartNumber) {

        ShoppingCartQueryResponseDTO shoppingCartQueryResponseDTO = shoppingCartService.getShoppingCartQuery(cartNumber);

        if (shoppingCartQueryResponseDTO != null) {
            return new ResponseEntity<>(shoppingCartQueryResponseDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>("Can't find cart with the cart number: " + cartNumber,
                HttpStatus.NOT_FOUND);
    }

    @GetMapping
    ResponseEntity<?> getAllShoppingCart() {
        return new ResponseEntity<>(shoppingCartService.getAllShoppingCartQuery(), HttpStatus.OK);
    }

    @GetMapping("/chackout/{cartNumber}/{customerId}")
    ResponseEntity<?> checkoutShoppingCart(@PathVariable String cartNumber, @PathVariable String customerId) {

         String order = shoppingCartService.getShoppingCartQueryCheckout(cartNumber, customerId);


        return new ResponseEntity<>("your shopping cart is ordered.... \n "+order, HttpStatus.OK);
    }


}
