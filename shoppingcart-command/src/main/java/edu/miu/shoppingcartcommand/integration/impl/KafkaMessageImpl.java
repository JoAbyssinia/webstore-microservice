package edu.miu.shoppingcartcommand.integration.impl;
import edu.miu.shoppingcartcommand.dto.response.ShoppingCartResponseDTO;
import edu.miu.shoppingcartcommand.integration.KafkaMessage;
import org.springframework.kafka.core.KafkaTemplate;

import org.springframework.stereotype.Component;

@Component
public class KafkaMessageImpl implements KafkaMessage {

    private final KafkaTemplate<String, ShoppingCartResponseDTO> kafkaTemplate;

    public KafkaMessageImpl(KafkaTemplate<String, ShoppingCartResponseDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendMessage(String topic, ShoppingCartResponseDTO shoppingCartResponseDTO) {
        kafkaTemplate.send(topic, shoppingCartResponseDTO);
    }
}
