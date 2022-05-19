package edu.miu.orderservice.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderConfirmRequestDTO {
    private String orderNumber;
    private String  customerID;
}
