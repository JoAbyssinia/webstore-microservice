package edu.miu.shoppingcartcommand.kafka;

import edu.miu.shoppingcartcommand.dto.response.ShoppingCartResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShoppingCartEvent{
    String event;
    ShoppingCartResponseDTO shoppingCartResponseDTO;
    String cartNumber;

}
