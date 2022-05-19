package edu.miu.orderservice.util;

import edu.miu.orderservice.dto.request.EmailRequestDTO;
import edu.miu.orderservice.dto.response.CustomerResponseDTO;

public class EmailUtils {

    public static EmailRequestDTO composeEmail(String orderNumber, CustomerResponseDTO customer){
        return EmailRequestDTO.builder()
                .customerName(customer.getFirstName()+" "+customer.getLastName())
                .message("\nThank you! your order has been successfully placed.\n \nYour OrderID is : " + orderNumber)
                .sendTo(customer.getEmail())
                .build();
    }
}
