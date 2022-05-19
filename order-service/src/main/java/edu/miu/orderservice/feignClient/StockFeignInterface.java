package edu.miu.orderservice.feignClient;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Map;

@FeignClient("stock-service")
@LoadBalancerClient("stock-service")
public interface StockFeignInterface {

    @PutMapping("/api/v1/stock/update")
    ResponseEntity<?> updateProduct(Map<String,Integer> productQuantityMap);
}
