package edu.miu.shoppingcartcommand.kafka;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShoppingCartKafkaProducerConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String boostrapServer;

    public Map<String, Object> producerConfig(){
        Map<String, Object> properties = new HashMap<>();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, boostrapServer);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, ShoppingCartEventSerializer.class);
        return properties;
    }

    @Bean
    public ProducerFactory<String, ShoppingCartEvent> producerFactory(){
        return new DefaultKafkaProducerFactory<>(producerConfig());
    }

    @Bean
    public KafkaTemplate<String, ShoppingCartEvent> kafkaTemplate(
            ProducerFactory<String, ShoppingCartEvent> producerFactory){
        return new KafkaTemplate<>(producerFactory);
    }
}
