package nl.inholland.myfirstbeerapi.dao;

import nl.inholland.myfirstbeerapi.model.Stock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends CrudRepository<Stock, Long>
{
    Iterable<Stock> getAllByQuantityGreaterThanEqualOrderByQuantity(int minimum);

    @Query("select s.quantity * g.price from Stock s, Beer g where s.beer.id = g.id and s.beer.id = ?1")
    int getStockValueByBeerId(Long id);
}