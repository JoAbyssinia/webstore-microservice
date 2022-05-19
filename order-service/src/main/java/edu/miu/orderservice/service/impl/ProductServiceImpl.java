package edu.miu.orderservice.service.impl;

import edu.miu.orderservice.feignClient.StockFeignInterface;
import edu.miu.orderservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private StockFeignInterface stockFeignInterface;


    @Override
    public Boolean updateProductStock(Map<String,Integer> productQuantityMap) {
        ResponseEntity<?> response= stockFeignInterface.updateProduct(productQuantityMap);
        return response.getStatusCode().value() == 200;
    }
}
