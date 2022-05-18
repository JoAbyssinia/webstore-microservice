package edu.miu.shoppingcartcommand.repository;

import edu.miu.shoppingcartcommand.entity.ShoppingCart;
import edu.miu.shoppingcartcommand.service.ShoppingCartService;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShoppingCartRepository extends MongoRepository<ShoppingCart, String> {

    @Query(value="{ 'cartNumber' :?0}")
    Optional<ShoppingCart> findByCartNumber(String cartNumber);
}
