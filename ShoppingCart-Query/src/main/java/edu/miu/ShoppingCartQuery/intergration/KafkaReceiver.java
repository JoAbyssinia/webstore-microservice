package edu.miu.ShoppingCartQuery.intergration;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaReceiver {

        @KafkaListener(topics = {"create-cart"})
    public void receiveCreateCart(@Payload String s){

        }

}
