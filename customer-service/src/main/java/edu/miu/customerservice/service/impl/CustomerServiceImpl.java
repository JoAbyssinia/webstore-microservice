package edu.miu.customerservice.service.impl;

import edu.miu.customerservice.dto.request.CustomerRequestDTO;
import edu.miu.customerservice.dto.response.CustomerResponseDTO;
import edu.miu.customerservice.entity.Customer;
import edu.miu.customerservice.repository.CustomerRepository;
import edu.miu.customerservice.service.CustomerService;
import edu.miu.customerservice.util.CustomerUtils;
import org.springframework.stereotype.Service;

import javax.naming.NotContextException;
import java.util.List;
import java.util.Optional;

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

    @Override
    public CustomerResponseDTO deleteCustomer(String customerID) {
        Optional<Customer> isCustomerExist = customerRepository.findByCustomerID(customerID);
        if (isCustomerExist.isEmpty()) {
            return null;
        }
        Customer toBeDeletedCustomer = isCustomerExist.get();
        customerRepository.delete(toBeDeletedCustomer);
        return CustomerUtils.parseCustomerToCustomerResponseDTO(isCustomerExist.get());
    }

    @Override
    public CustomerResponseDTO getCustomerByCustomerID(String customerID) {
        Optional<Customer> isCustomerExist = customerRepository.findByCustomerID(customerID);
        return isCustomerExist.map(CustomerUtils::parseCustomerToCustomerResponseDTO).orElse(null);
    }
}
