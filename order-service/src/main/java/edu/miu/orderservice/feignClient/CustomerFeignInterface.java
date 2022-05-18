package edu.miu.orderservice.feignClient;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("customer-service")
public interface CustomerFeignInterface {
}
