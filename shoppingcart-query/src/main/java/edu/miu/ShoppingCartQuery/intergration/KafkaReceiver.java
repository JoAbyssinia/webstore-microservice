package edu.miu.ShoppingCartQuery.intergration;

import edu.miu.ShoppingCartQuery.dto.request.ShoppingCartQueryRequestDTO;
import edu.miu.ShoppingCartQuery.service.ShoppingCartService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaReceiver {


    private final ShoppingCartService shoppingCartService;

    public KafkaReceiver(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @KafkaListener(topics = {"create-cart"})
    public void receiveCreateCart(@Payload
                                  ShoppingCartQueryRequestDTO shoppingCartQueryRequestDTO){
            shoppingCartService.addShoppingCartQuery(shoppingCartQueryRequestDTO);
        }

}
