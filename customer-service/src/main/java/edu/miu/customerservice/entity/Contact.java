package edu.miu.customerservice.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Contact {
    private String email;
    private String phone;
}
