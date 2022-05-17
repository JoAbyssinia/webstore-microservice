package edu.miu.customerservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
public class CustomerResponseDTO {
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String city;
    private String street;
    private String zip;
}
