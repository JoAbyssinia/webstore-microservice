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
    private String customerID;
    private String firstName;
    private String lastName;
    private Address address;
    private Contact contact;

    public Customer(Long id,
                    String customerID,
                    String firstName,
                    String lastName,
                    Address address,
                    Contact contact) {
        this.id = id;
        this.customerID = customerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.contact = contact;
    }
}
