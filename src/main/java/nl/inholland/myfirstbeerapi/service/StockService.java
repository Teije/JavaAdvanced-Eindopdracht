package nl.inholland.myfirstbeerapi.service;

import nl.inholland.myfirstbeerapi.dao.StockRepository;
import nl.inholland.myfirstbeerapi.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService
{
    @Autowired
    private StockRepository stockRepository;

    // Get all stocks available
    public List<Stock> getAllStocks() {
        System.out.println("In service");
        return (List<Stock>) stockRepository.findAll();
    }
}
