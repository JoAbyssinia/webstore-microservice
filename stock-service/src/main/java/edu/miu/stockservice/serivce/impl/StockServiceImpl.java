package edu.miu.stockservice.serivce.impl;

import edu.miu.stockservice.dto.requestDto.StockRequestDTO;
import edu.miu.stockservice.dto.responceDto.StockResponseDTO;
import edu.miu.stockservice.entity.Stock;
import edu.miu.stockservice.repository.StockRepository;
import edu.miu.stockservice.serivce.StockService;
import edu.miu.stockservice.util.StockUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StockServiceImpl implements StockService {

    private final StockRepository stockRepository;

    public StockServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }


    @Override
    public StockResponseDTO addStock(StockRequestDTO stockRequestDTO) {
        Stock stock = StockUtils.parseStockRequestDTOToStock(stockRequestDTO);
        stockRepository.save(stock);
        return StockUtils.parseStockToStockResponseDTO(stock);
    }

    @Override
    public StockResponseDTO updateStock(String productNumber, StockRequestDTO stockRequestDTO) {
        Optional<Stock> isFound = stockRepository.findByProductNumber(productNumber);
        if (isFound.isPresent()) {
            Stock stock = isFound.get();
            stock.setQuantity(stockRequestDTO.getQuantity());
            stockRepository.save(stock);
            return StockUtils.parseStockToStockResponseDTO(stock);
        }
        return null;
    }

    @Override
    public StockResponseDTO deleteStock(String productNumber) {

        Optional<Stock> isFound = stockRepository.findByProductNumber(productNumber);
        if (isFound.isPresent()) {
            Stock stock = isFound.get();
            stockRepository.save(stock);
            return StockUtils.parseStockToStockResponseDTO(stock);
        }
        return null;
    }

    @Override
    public List<StockResponseDTO> getAllStock() {
        List<StockResponseDTO> stockResponseDTOS = new ArrayList<>();
        stockRepository.findAll().forEach(stock -> {
            stockResponseDTOS.add(StockResponseDTO.builder()
                    .productNumber(stock.getProductNumber())
                    .quantity(stock.getQuantity())
                    .build());
        });
        return stockResponseDTOS;
    }

    @Override
    public StockResponseDTO getStock(String productNumber) {
        Optional<Stock> isStockFound = stockRepository.findByProductNumber(productNumber);
        return isStockFound.map(StockUtils::parseStockToStockResponseDTO).orElse(null);
    }
}
