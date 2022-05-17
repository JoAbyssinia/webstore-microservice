package edu.miu.customerservice.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CustomerRequestDTO implements Serializable {
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String city;
    private String street;
    private Integer zip;
}
