package edu.miu.ShoppingCartQuery.feignClient;


import edu.miu.ShoppingCartQuery.dto.request.OrderRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient("stock-service")
public interface OrderFeignInterface {

    @PostMapping("/api/v1/orders/checkout")
    void checkout(@RequestBody OrderRequestDTO orderRequestDTO);

}
