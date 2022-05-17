package edu.miu.customerservice.controller.v1;

import edu.miu.customerservice.dto.request.CustomerRequestDTO;
import edu.miu.customerservice.dto.response.CustomerResponseDTO;
import edu.miu.customerservice.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<?> addCustomer(@RequestBody CustomerRequestDTO customerRequestDTO){
        return new ResponseEntity<CustomerResponseDTO>(
                customerService.addCustomer(customerRequestDTO),
                HttpStatus.CREATED);
    }
}
