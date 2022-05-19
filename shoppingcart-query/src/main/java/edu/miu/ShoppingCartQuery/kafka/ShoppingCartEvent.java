package edu.miu.ShoppingCartQuery.kafka;

import edu.miu.ShoppingCartQuery.dto.ShoppingCartResponseDTO;
import edu.miu.ShoppingCartQuery.dto.request.ShoppingCartQueryRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShoppingCartEvent {
    String event;
    ShoppingCartResponseDTO shoppingCartResponseDTO;
    String cartNumber;

}
