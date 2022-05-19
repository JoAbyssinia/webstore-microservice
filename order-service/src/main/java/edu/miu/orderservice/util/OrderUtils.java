package edu.miu.orderservice.util;

import edu.miu.orderservice.dto.request.ShoppingCartRequestDTO;
import edu.miu.orderservice.entity.Order;
import edu.miu.orderservice.entity.OrderLine;

import java.util.*;

import static edu.miu.orderservice.util.RandomNumberGenerator.getRandomNumbers;

public class OrderUtils {

    public static Order parseShoppingCartRequestDTOToOrder(ShoppingCartRequestDTO shoppingCartRequestDTO, String customerID){
        List<OrderLine> orderLineList=new ArrayList<>();
        Order order=new Order();
        shoppingCartRequestDTO.getProductLines().forEach(orderLine -> {
            OrderLine oL=new OrderLine();
            oL.setQuantity(orderLine.getQuantity());
            oL.setProduct(orderLine.getProduct());
            orderLineList.add(oL);
        });
        order.setOrderLine(orderLineList);
        order.setOrderDate(new Date());
        order.setOrderNumber(getRandomNumbers());
        order.setCustomerID(customerID);
        order.setOrderStatus('N');
        return order;
    }

    public static Map<String, Integer> getProductQuantity(Order order){
        Map<String, Integer> productQuantityMap=new HashMap<>();
        order.getOrderLine().forEach(orderLine->{
            productQuantityMap.put(orderLine.getProduct().getProductNumber(),orderLine.getQuantity());
        });
        return productQuantityMap;
    }
}
