package edu.miu.stockservice.Controller.v1;


import edu.miu.stockservice.dto.requestDto.StockRequestDTO;
import edu.miu.stockservice.dto.responceDto.StockResponseDTO;
import edu.miu.stockservice.error.StockErrorHandler;
import edu.miu.stockservice.serivce.StockService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/stock")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }


    @PostMapping
    ResponseEntity<?> addStock(@RequestBody StockRequestDTO stockRequestDTO) {
        StockResponseDTO stockResponseDTO = stockService.addStock(stockRequestDTO);
        return new ResponseEntity<>(stockResponseDTO, HttpStatus.OK);
    }

    @GetMapping("/{productNumber}")
    ResponseEntity<?> getStock(@PathVariable String productNumber) {
        StockResponseDTO stockResponseDTO = stockService.getStock(productNumber);
        if (stockResponseDTO != null) {
            return new ResponseEntity<>(stockResponseDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>("Can't find Stock with the product number: " + productNumber,
                HttpStatus.NOT_FOUND);
    }

    @GetMapping
    ResponseEntity<?> getAllStock() {
        return new ResponseEntity<>(stockService.getAllStock(), HttpStatus.OK);
    }

    @DeleteMapping("/{productNumber}")
    ResponseEntity<?> deleteStock(@PathVariable String productNumber) {
        StockResponseDTO deleteStock = stockService.deleteStock(productNumber);
        return new ResponseEntity<>(deleteStock, HttpStatus.OK);
    }

    @PutMapping("/{productNumber}")
    ResponseEntity<?> updateProduct(@PathVariable String productNumber, @RequestBody StockRequestDTO stockRequestDTO) {

        StockResponseDTO stockResponseDTO = stockService.updateStock(productNumber, stockRequestDTO);

        if (stockResponseDTO != null) {
            return new ResponseEntity<>(stockResponseDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>("Stock with this product number " + productNumber + " couldn't find",
                HttpStatus.NOT_FOUND);

    }

    @PutMapping("/update")
    public ResponseEntity<?> updateProduct(@RequestBody Map<String,Integer> productQuantityMap) throws InterruptedException {
        System.out.println("############## Updating Product Quantity in Stock Service ##############");
        Boolean result = stockService.updateProductStock(productQuantityMap);
        if(result){
            return new ResponseEntity<>(new StockErrorHandler(true),HttpStatus.OK);
        }
        return new ResponseEntity<>(new StockErrorHandler(false),
                HttpStatus.UNPROCESSABLE_ENTITY);
    }


}
