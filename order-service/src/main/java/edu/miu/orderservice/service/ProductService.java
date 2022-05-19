package edu.miu.orderservice.service;

import java.util.Map;

public interface ProductService {
   Boolean updateProductStock(Map<String,Integer> productQuantityMap);
}
