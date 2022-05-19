package edu.miu.productservice.feignClient;

import edu.miu.productservice.dto.request.StockRequestDTO;
import edu.miu.productservice.dto.response.StockResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient("stock-service")
public interface StockInterface {
    @GetMapping("/api/v1/stock/{productNumber}")
    StockResponseDTO getStock(@PathVariable String productNumber);

    @PostMapping("/api/v1/stock/")
    StockResponseDTO addStock(@RequestBody StockRequestDTO stockRequestDTO);

    @DeleteMapping("/api/v1/stock/{productNumber}")
    StockResponseDTO deleteStock(@PathVariable String productNumber);

    @PutMapping("/api/v1/stock/{productNumber}")
    StockResponseDTO updateProduct(@PathVariable String productNumber, @RequestBody StockRequestDTO stockRequestDTO);

}
