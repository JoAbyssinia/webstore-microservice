package edu.miu.orderservice.feignClient;

import edu.miu.orderservice.dto.request.EmailRequestDTO;
import edu.miu.orderservice.dto.response.CustomerResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Component
@FeignClient("customer-service")
public interface CustomerFeignInterface {

    @GetMapping("/api/v1/customers/{customerID}")
    CustomerResponseDTO getCustomers(@PathVariable String customerID);

    @PostMapping("/api/v1/customers/email")
    String sendEmail(@RequestBody EmailRequestDTO emailRequestDTO);

}
