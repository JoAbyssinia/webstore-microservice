package edu.miu.customerservice.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EmailRequestDTO {
    private String sendTo;
    private String message;
    private String customerName;
}
