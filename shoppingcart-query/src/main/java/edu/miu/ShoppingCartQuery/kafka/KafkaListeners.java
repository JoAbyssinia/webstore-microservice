package edu.miu.ShoppingCartQuery.kafka;

import edu.miu.ShoppingCartQuery.dto.request.ShoppingCartQueryRequestDTO;
import edu.miu.ShoppingCartQuery.entity.Product;
import edu.miu.ShoppingCartQuery.entity.ProductLine;
import edu.miu.ShoppingCartQuery.service.ShoppingCartService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class KafkaListeners {

    private final ShoppingCartService shoppingCartService;

    public KafkaListeners(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @KafkaListener(topics = "shoppigcarttopic", groupId = "1"
    )
    void listener(String cartEvent) throws JsonProcessingException {

        ShoppingCartEvent event = new ObjectMapper().readValue(cartEvent, ShoppingCartEvent.class);

        ShoppingCartQueryRequestDTO shoppingCartQueryRequestDTO = new ShoppingCartQueryRequestDTO();
        List<ProductLine> productLines = new ArrayList<>();
        event.getShoppingCartResponseDTO().getProductLineResponseDTOList().forEach(productLineResponseDTO -> {
            ProductLine productLine = new ProductLine();
                Product product = Product.builder()
                        .productNumber(productLineResponseDTO.getProduct().getProductNumber())
                        .price(productLineResponseDTO.getProduct().getPrice())
                        .name(productLineResponseDTO.getProduct().getName())
                        .description(productLineResponseDTO.getProduct().getDescription())
                        .build();
            productLine.setProduct(product);
            productLine.setQuantity(productLineResponseDTO.getQuantity());

            productLines.add(productLine);

        });

        shoppingCartQueryRequestDTO.setProductLines(productLines);
        shoppingCartQueryRequestDTO.setCartNumber(event.getShoppingCartResponseDTO().getCartNumber());


        String quantity = event.getShoppingCartResponseDTO().getCartNumber();
//        Integer number = event.getShoppingCartResponseDTO();


        switch (event.event) {

            case "ADD" -> shoppingCartService.addShoppingCartQuery(shoppingCartQueryRequestDTO);

            case "ADD-PRODUCT" -> shoppingCartService.addProduct(shoppingCartQueryRequestDTO);

//            case "REMOVE" -> shoppingCartService.removeFromCart(event.getProduct(), event.getCartNumber());

        }

    }
}
