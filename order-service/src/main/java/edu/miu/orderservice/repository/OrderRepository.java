package edu.miu.orderservice.repository;

import edu.miu.orderservice.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface OrderRepository extends MongoRepository<Order, BigInteger> {
}
