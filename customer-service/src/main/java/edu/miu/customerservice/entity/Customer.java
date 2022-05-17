package edu.miu.customerservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    private BigInteger id;
    private String customerID;
    private String firstName;
    private String lastName;
    private Address address;
    private Contact contact;

//    public Customer(BigInteger id,
//                    String customerID,
//                    String firstName,
//                    String lastName,
//                    Address address,
//                    Contact contact) {
//        this.id = id;
//        this.customerID = customerID;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.address = address;
//        this.contact = contact;
//    }
}
