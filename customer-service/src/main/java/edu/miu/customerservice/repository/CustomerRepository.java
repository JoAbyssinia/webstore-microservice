package edu.miu.customerservice.repository;

import edu.miu.customerservice.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, BigInteger>{

    @Query(value="{ 'customerID' :?0}")
    Optional<Customer> findByCustomerID(String customerID);
}
