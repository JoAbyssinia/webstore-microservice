package edu.miu.customerservice.controller.v1;

import edu.miu.customerservice.dto.request.CustomerRequestDTO;
import edu.miu.customerservice.dto.response.CustomerResponseDTO;
import edu.miu.customerservice.error.GenericCustomerError;
import edu.miu.customerservice.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<?> addCustomer(@RequestBody CustomerRequestDTO customerRequestDTO){
        return new ResponseEntity<>(
                customerService.addCustomer(customerRequestDTO),
                HttpStatus.CREATED);
    }
    @DeleteMapping("/{customerID}")
    public ResponseEntity<?> deleteCustomer(@PathVariable String customerID){
        Optional<CustomerResponseDTO> customerResponseDTO = Optional.ofNullable(
                customerService.deleteCustomer(customerID));
        if(customerResponseDTO.isEmpty()){ return new ResponseEntity<>(
                customerResponseDTO.get(),
                HttpStatus.OK);
        }
        return new ResponseEntity<>(
                getGenericCustomerError("Customer with ID : " + customerID + " Not Found"),
                HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{customerID}")
    public ResponseEntity<?> getCustomers(@PathVariable String customerID){
        Optional<CustomerResponseDTO> customerByCustomerID = Optional.ofNullable(
                customerService.getCustomerByCustomerID(customerID));
        if(customerByCustomerID.isEmpty()){
            return new ResponseEntity<>(
                    getGenericCustomerError("Customer with ID : " + customerID + " Not Found"),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                customerByCustomerID.get(),
                HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllCustomers() {
        Optional<List<CustomerResponseDTO>> customerResponseDTOList =
                Optional.ofNullable(customerService.getAllCustomers());
        if(customerResponseDTOList.isEmpty()){
            return new ResponseEntity<>(
                    getGenericCustomerError("Customers Not Found"),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                customerResponseDTOList.get(),
                HttpStatus.OK);
    }

    @PutMapping("/{customerID}")
    public ResponseEntity<?> updateCustomer(@PathVariable String customerID,
                                            @RequestBody CustomerRequestDTO customerRequestDTO){
        Optional<CustomerResponseDTO> customerResponseDTOList =
                Optional.ofNullable(customerService.updateCustomer(customerID, customerRequestDTO));
        if(customerResponseDTOList.isEmpty()){
            return new ResponseEntity<>(
                    getGenericCustomerError("Customer with ID : " + customerID + " Not Found"),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                customerResponseDTOList.get(),
                HttpStatus.OK);
    }

    public GenericCustomerError getGenericCustomerError(String message){
        return new GenericCustomerError(message);
    }
}
