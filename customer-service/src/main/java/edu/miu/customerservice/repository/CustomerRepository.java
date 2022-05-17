package edu.miu.customerservice.repository;

import edu.miu.customerservice.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, BigInteger>{
}
