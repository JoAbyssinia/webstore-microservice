package edu.miu.shoppingcartcommand.feignClient;

import edu.miu.shoppingcartcommand.dto.response.ShoppingCartResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient("product-service")
public interface ProductInterface {

    @GetMapping("/api/v1/product/{productNumber}")
    ShoppingCartResponseDTO getProduct(@PathVariable String productNumber);
}
