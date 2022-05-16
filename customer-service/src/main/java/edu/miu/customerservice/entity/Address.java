package edu.miu.customerservice.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Address {
    private String street;
    private String city;
    private Integer zip;
}
