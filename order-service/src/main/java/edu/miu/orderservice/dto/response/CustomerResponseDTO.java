package edu.miu.orderservice.dto.response;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerResponseDTO {
    private String customerID;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String city;
    private String street;
    private Integer zip;
}
