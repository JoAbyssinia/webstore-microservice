package edu.miu.productservice.repository;

import edu.miu.productservice.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product,Long> {

    Optional<Product> findByProductNumber(String productNumber);
}
