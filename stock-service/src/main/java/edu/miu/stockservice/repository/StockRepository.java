package edu.miu.stockservice.repository;

import edu.miu.stockservice.entity.Stock;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;
@Repository
public interface StockRepository extends MongoRepository<Stock, BigInteger> {

    Optional<Stock> findByProductNumber(String productNumber);

}
