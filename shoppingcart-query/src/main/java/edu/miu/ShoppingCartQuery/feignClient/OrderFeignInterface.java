package edu.miu.ShoppingCartQuery.feignClient;


import edu.miu.ShoppingCartQuery.dto.request.OrderRequestDTO;
import edu.miu.ShoppingCartQuery.entity.order.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient("order-service")
public interface OrderFeignInterface {

    @PostMapping("/api/v1/orders/checkout")
    String checkout(@RequestBody OrderRequestDTO orderRequestDTO);

}
