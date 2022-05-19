package edu.miu.orderservice.service.impl;

import edu.miu.orderservice.dto.request.OrderRequestDTO;
import edu.miu.orderservice.dto.request.ShoppingCartRequestDTO;
import edu.miu.orderservice.dto.response.CustomerResponseDTO;
import edu.miu.orderservice.entity.Order;
import edu.miu.orderservice.error.OrderErrorType;
import edu.miu.orderservice.feignClient.CustomerFeignInterface;
import edu.miu.orderservice.repository.OrderRepository;
import edu.miu.orderservice.service.OrderService;
import edu.miu.orderservice.util.OrderUtils;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CustomerFeignInterface customerFeignInterface;

    public OrderServiceImpl(OrderRepository orderRepository, CustomerFeignInterface customerFeignInterface) {
        this.orderRepository = orderRepository;
        this.customerFeignInterface = customerFeignInterface;
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
}
