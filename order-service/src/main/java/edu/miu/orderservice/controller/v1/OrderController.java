package edu.miu.orderservice.controller.v1;

import edu.miu.orderservice.dto.request.OrderConfirmRequestDTO;
import edu.miu.orderservice.dto.request.OrderRequestDTO;
import edu.miu.orderservice.entity.Order;
import edu.miu.orderservice.error.OrderErrorType;
import edu.miu.orderservice.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

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
    @PostMapping("/confirm")
    public ResponseEntity<?> confirmOrder(@RequestBody OrderConfirmRequestDTO orderConfirmRequestDTO) {
        String message="";
        try{
            message= orderService.confirmOrder(orderConfirmRequestDTO);
        }catch (RuntimeException ex){
            System.out.println(" ************ There is an issue in Order Confirmation! *************");
            return ResponseEntity.ok(new OrderErrorType("Sorry, cannot place your order. Try again later"));
        }
        return ResponseEntity.ok(message);
    }

    @GetMapping("/{orderNumber}")
    public ResponseEntity<?> getOrder(@PathVariable("orderNumber") String orderNumber) {
        Order order=orderService.getOrder(orderNumber);
        if(Objects.isNull(order)){
            return new ResponseEntity<>(
                    "Order with Order Number : " + orderNumber + " Not Found",
                    HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(order);
    }


}
