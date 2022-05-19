package edu.miu.orderservice.feignClient;

import edu.miu.orderservice.dto.response.CustomerResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Component
@FeignClient("customer-service")
public interface CustomerFeignInterface {

    @GetMapping("/api/v1/customers/{customerID}")
    CustomerResponseDTO getCustomers(@PathVariable String customerID);

}
