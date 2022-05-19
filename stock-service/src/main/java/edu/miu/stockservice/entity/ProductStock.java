package edu.miu.stockservice.entity;

import edu.miu.stockservice.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProductStock {

    @Autowired
    StockRepository stockRepository;

    public boolean checkProduct(String productNumber,int quantity) {
        Optional<Stock> optionalProduct = stockRepository.findByProductNumber(productNumber);
        if(optionalProduct.isPresent()){
            if(optionalProduct.get().getQuantity() >= quantity){
                return true;
            }
            return false;
        }
        return false;
    }

    public void changeProduct(String productNumber, int quantity) {
        Optional<Stock> optionalProduct = stockRepository.findByProductNumber(productNumber);
        if(optionalProduct.isPresent()){
            Stock stock = optionalProduct.get();
            stock.decrementQuantity(quantity);
            stockRepository.save(stock);
        }
    }

}

