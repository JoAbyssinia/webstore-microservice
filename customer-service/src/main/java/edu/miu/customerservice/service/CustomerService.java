package edu.miu.customerservice.service;

import edu.miu.customerservice.dto.request.CustomerRequestDTO;
import edu.miu.customerservice.dto.response.CustomerResponseDTO;
import edu.miu.customerservice.entity.Customer;

public interface CustomerService {

    CustomerResponseDTO addCustomer(CustomerRequestDTO customerDTO);

    CustomerResponseDTO deleteCustomer(String customerID);

    CustomerResponseDTO getCustomerByCustomerID(String customerID);
}
