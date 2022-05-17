package edu.miu.productservice.repository;

import edu.miu.productservice.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends MongoRepository<Product,Long> {

    Optional<Product> findByProductNumber(String productNumber);
}
