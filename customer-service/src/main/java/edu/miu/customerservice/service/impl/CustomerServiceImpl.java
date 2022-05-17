package edu.miu.customerservice.service.impl;

import edu.miu.customerservice.dto.request.CustomerRequestDTO;
import edu.miu.customerservice.dto.response.CustomerResponseDTO;
import edu.miu.customerservice.entity.Customer;
import edu.miu.customerservice.repository.CustomerRepository;
import edu.miu.customerservice.service.CustomerService;
import edu.miu.customerservice.util.CustomerUtils;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerResponseDTO addCustomer(CustomerRequestDTO customerRequestDTO) {
        Customer customer = CustomerUtils.parseCustomerRequestDTOToCustomer(customerRequestDTO);
        customerRepository.save(customer);
        return CustomerUtils.parseCustomerToCustomerResponseDTO(customer);
    }
}
