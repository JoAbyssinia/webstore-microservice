package edu.miu.orderservice.controller.v1;

import edu.miu.orderservice.dto.request.OrderRequestDTO;
import edu.miu.orderservice.entity.Order;
import edu.miu.orderservice.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/checkout")
    public ResponseEntity<?> checkout(@RequestBody OrderRequestDTO orderRequestDTO) {
        Order order=new Order();
        try{
            order = orderService.checkoutOrder(orderRequestDTO);
        }catch (Exception ex){
            return ResponseEntity.ok(ex.getMessage());
        }
        return ResponseEntity.ok(order);
    }
}
