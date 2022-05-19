package edu.miu.webshopclient.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class Customer {
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String city;
    private String street;
    private Integer zip;
}
