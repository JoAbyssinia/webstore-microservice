package edu.miu.ShoppingCartQuery.repository;

import edu.miu.ShoppingCartQuery.entity.ShoppingCartQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface ShoppingCartQueryRepository extends MongoRepository<ShoppingCartQuery, BigInteger> {


    Optional<ShoppingCartQuery> findByCartNumber(String cartNumber);

}
