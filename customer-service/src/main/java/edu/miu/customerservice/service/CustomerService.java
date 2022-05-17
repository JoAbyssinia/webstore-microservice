package edu.miu.customerservice.service;

import edu.miu.customerservice.dto.request.CustomerRequestDTO;
import edu.miu.customerservice.dto.response.CustomerResponseDTO;
import edu.miu.customerservice.entity.Customer;

import java.util.List;

public interface CustomerService {

    CustomerResponseDTO addCustomer(CustomerRequestDTO customerRequestDTO);

    CustomerResponseDTO deleteCustomer(String customerID);

    CustomerResponseDTO getCustomerByCustomerID(String customerID);

    List<CustomerResponseDTO> getAllCustomers();

    CustomerResponseDTO updateCustomer(String customerID, CustomerRequestDTO customerRequestDTO);
}
