package edu.miu.orderservice.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
public class EmailRequestDTO {
    private String sendTo;
    private String customerName;
    private String message;
}
