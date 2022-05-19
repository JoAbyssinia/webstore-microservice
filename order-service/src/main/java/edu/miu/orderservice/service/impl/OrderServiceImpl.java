package edu.miu.orderservice.service.impl;

import edu.miu.orderservice.dto.request.EmailRequestDTO;
import edu.miu.orderservice.dto.request.OrderConfirmRequestDTO;
import edu.miu.orderservice.dto.request.OrderRequestDTO;
import edu.miu.orderservice.dto.request.ShoppingCartRequestDTO;
import edu.miu.orderservice.dto.response.CustomerResponseDTO;
import edu.miu.orderservice.entity.Order;
import edu.miu.orderservice.error.OrderErrorType;
import edu.miu.orderservice.feignClient.CustomerFeignInterface;
import edu.miu.orderservice.repository.OrderRepository;
import edu.miu.orderservice.service.OrderService;
import edu.miu.orderservice.service.ProductService;
import edu.miu.orderservice.util.OrderUtils;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

import static edu.miu.orderservice.util.EmailUtils.composeEmail;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CustomerFeignInterface customerFeignInterface;
    private final ProductService productService;

    public OrderServiceImpl(OrderRepository orderRepository, CustomerFeignInterface customerFeignInterface,
                            ProductService productService) {
        this.orderRepository = orderRepository;
        this.customerFeignInterface = customerFeignInterface;
        this.productService = productService;
    }

    @Override
    public Order checkoutOrder(OrderRequestDTO orderRequestDTO) throws OrderErrorType {
        ShoppingCartRequestDTO shoppingCart = orderRequestDTO.getShoppingCart();
        Optional<CustomerResponseDTO> feignCustomerResponse = Optional.ofNullable(customerFeignInterface.getCustomers(orderRequestDTO.getCustomerID()));
        if(Objects.isNull(shoppingCart) && Objects.isNull(feignCustomerResponse)){
            return null;
        }
        if(feignCustomerResponse.isPresent()){
            Order order = OrderUtils.parseShoppingCartRequestDTOToOrder(shoppingCart, orderRequestDTO.getCustomerID());
            orderRepository.save(order);
            return order;
        }else{
            throw new OrderErrorType("Customer with CustomerID: " + orderRequestDTO.getCustomerID() + " not found!");
        }
    }
    @Override
    public String confirmOrder(OrderConfirmRequestDTO orderConfirmRequestDTO) {
        Order order=orderRepository.findByOrderNumber(orderConfirmRequestDTO.getOrderNumber())
                .orElseGet(()->{
                    throw new NoSuchElementException("Sorry, Order not found");
                });

        Boolean message=productService.updateProductStock(OrderUtils.getProductQuantity(order));
        if(!message){
            throw new RuntimeException("Sorry! Product is out of stock");
        }
        order.setOrderStatus('Y');
        orderRepository.save(order);
        CustomerResponseDTO customer = customerFeignInterface.getCustomers(order.getCustomerID());

        EmailRequestDTO emailRequestDTO = composeEmail(order.getOrderNumber(), customer);
        String responseEntity = customerFeignInterface.sendEmail(emailRequestDTO);
        if(responseEntity.equals("Email Sent....")){
            return "Dear Customer,\nYour order has been confirmed.\n\nYour order number is: " +
                    orderConfirmRequestDTO.getOrderNumber() +"\nThank you!";
        }else{
            return responseEntity;
        }
    }
}
