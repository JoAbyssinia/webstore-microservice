package edu.miu.customerservice.entity;

import lombok.*;

@Getter
@Setter
@Builder
public class Address {
    private String street;
    private String city;
    private Integer zip;
}
