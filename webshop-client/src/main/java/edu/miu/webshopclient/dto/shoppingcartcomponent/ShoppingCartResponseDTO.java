package edu.miu.webshopclient.dto.shoppingcartcomponent;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@Data
public class ShoppingCartResponseDTO {
    private String cartNumber;
    private List<ProductLineResponseDTO> productLineResponseDTOList;
}
