package nl.inholland.myfirstbeerapi.dao;

import nl.inholland.myfirstbeerapi.model.Beer;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;


import java.util.List;

@Repository
public interface BeerRepository extends CrudRepository<Beer, Long>
{
    // Get all beers for an equal or greater than the supplied value & order the result by Id
    List<Beer> getAllByPriceGreaterThanEqualOrderById(double value);
}
