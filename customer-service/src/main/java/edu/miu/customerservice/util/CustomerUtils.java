package edu.miu.customerservice.util;

import edu.miu.customerservice.dto.request.CustomerRequestDTO;
import edu.miu.customerservice.dto.response.CustomerResponseDTO;
import edu.miu.customerservice.entity.Address;
import edu.miu.customerservice.entity.Contact;
import edu.miu.customerservice.entity.Customer;

import java.util.Random;

public class CustomerUtils {

    public static Customer parseCustomerRequestDTOToCustomer(CustomerRequestDTO customerDTO){
        //TODO: MAKE INLINE VARIABLE AFTER SUCCESSFUL DEBUG
        Customer customer = new Customer(null,
                generateCustomerUniqueID(),
                customerDTO.getFirstName(),
                customerDTO.getLastName(),
                Address.builder()
                        .street(customerDTO.getStreet())
                        .city(customerDTO.getCity())
                        .zip(customerDTO.getZip())
                        .build(),
                Contact.builder()
                        .email(customerDTO.getEmail())
                        .phone(customerDTO.getPhone())
                        .build());
        return customer;
    }
    public static CustomerResponseDTO parseCustomerToCustomerResponseDTO(Customer customer){
        return null;
    }

    public static String generateCustomerUniqueID(){
        // It will generate 6 digit random Number.
        // from 0 to 999999
        Random rnd = new Random();
        int number = rnd.nextInt(999999);

        // this will convert any number sequence into 6 character.
        return String.format("%06d", number);
    }
}
