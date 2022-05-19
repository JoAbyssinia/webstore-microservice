package edu.miu.webshopclient.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class OrderConfirmRequestDTO {
    private String orderNumber;
    private String  customerID;
}
