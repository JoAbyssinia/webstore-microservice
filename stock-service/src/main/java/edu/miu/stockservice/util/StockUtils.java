package edu.miu.stockservice.util;

import edu.miu.stockservice.dto.requestDto.StockRequestDTO;
import edu.miu.stockservice.dto.responceDto.StockResponseDTO;
import edu.miu.stockservice.entity.Stock;

public class StockUtils {


    public static Stock parseStockRequestDTOToStock(StockRequestDTO stockRequestDTO) {
        return new Stock(null, stockRequestDTO.getProductNumber(), stockRequestDTO.getQuantity());
    }

    public static StockResponseDTO parseStockToStockResponseDTO(Stock stock) {
        return StockResponseDTO.builder().productNumber(stock.getProductNumber()).
                quantity(stock.getQuantity()).build();
    }

}
