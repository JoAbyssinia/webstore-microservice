package edu.miu.stockservice.serivce;

import edu.miu.stockservice.dto.requestDto.StockRequestDTO;
import edu.miu.stockservice.dto.responceDto.StockResponseDTO;

import java.util.List;
import java.util.Map;

public interface StockService {

    StockResponseDTO addStock(StockRequestDTO stockRequestDTO);

    StockResponseDTO updateStock(String productNumber, StockRequestDTO stockRequestDTO);

    StockResponseDTO deleteStock(String  productNumber);

    List<StockResponseDTO> getAllStock();

    StockResponseDTO getStock(String productNumber);

    Boolean updateProductStock(Map<String, Integer> productQuantityMap) throws InterruptedException;

}
