package nl.inholland.myfirstbeerapi.dao;

import nl.inholland.myfirstbeerapi.model.Beer;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;


import java.util.List;

@Repository
public interface BeerRepository extends CrudRepository<Beer, Long>
{
    List<Beer> getAllByPriceGreaterThanEqualOrderById(double value);
}
