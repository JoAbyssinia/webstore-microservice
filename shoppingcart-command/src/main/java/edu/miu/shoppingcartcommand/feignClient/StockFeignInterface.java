package edu.miu.shoppingcartcommand.feignClient;

import edu.miu.shoppingcartcommand.dto.response.ProductResponseFeignDTO;
import edu.miu.shoppingcartcommand.dto.response.StockResponseFeignDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("stock-service")
public interface StockFeignInterface {

    @GetMapping("/api/v1/stock/{productNumber}")
    StockResponseFeignDTO getStock(@PathVariable String productNumber);

}
