package edu.miu.customerservice.service.impl;

import edu.miu.customerservice.dto.request.CustomerRequestDTO;
import edu.miu.customerservice.dto.response.CustomerResponseDTO;
import edu.miu.customerservice.entity.Customer;
import edu.miu.customerservice.repository.CustomerRepository;
import edu.miu.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public CustomerResponseDTO addCustomer(CustomerRequestDTO customerRequestDTO) {

        return null;
    }
}
