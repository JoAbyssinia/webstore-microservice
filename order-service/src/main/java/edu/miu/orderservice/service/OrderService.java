package edu.miu.orderservice.service;

import edu.miu.orderservice.dto.request.OrderConfirmRequestDTO;
import edu.miu.orderservice.dto.request.OrderRequestDTO;
import edu.miu.orderservice.entity.Order;
import edu.miu.orderservice.error.OrderErrorType;

public interface OrderService {
    Order checkoutOrder(OrderRequestDTO orderRequestDTO) throws OrderErrorType;

    String confirmOrder(OrderConfirmRequestDTO orderConfirmRequestDTO);
}
