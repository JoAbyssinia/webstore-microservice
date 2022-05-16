package edu.miu.customerservice.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@Document
@Data
public class Customer {
    @Id
    private Long id;
    private BigInteger customerID;
    private String firstName;
    private String lastName;
    private Address address;
    private Contact contact;
}
