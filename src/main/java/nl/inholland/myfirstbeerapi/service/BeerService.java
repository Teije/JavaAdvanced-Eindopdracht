package nl.inholland.myfirstbeerapi.service;

import nl.inholland.myfirstbeerapi.dao.BeerRepository;
import nl.inholland.myfirstbeerapi.model.Beer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BeerService {

    @Autowired
    private BeerRepository beerRepository;

    public BeerService() { }

    public List<Beer> getAllBeers() {
        return (List<Beer>) beerRepository.findAll();
    }

    // Return all beers from the supplied brand
    public List<Beer> getBeersByBrand(String brand)
    {
        var result = new ArrayList<Beer>();

        for (var beer: beerRepository.findAll())
        {
            if(beer.getBrand().toLowerCase().equals(brand.toLowerCase()))
            {
                result.add(beer);
            }
        }
        return result;
    }

    // Get all beers at or below the supplied price
    public List<Beer> getBeersAtOrBelowPrice(Integer price)
    {
        var result = new ArrayList<Beer>();

        for (var beer: beerRepository.findAll())
        {
            if(beer.getPrice() <= price)
            {
                result.add(beer);
            }
        }
        return result;
    }

    // Add a beer
    public void addBeer(Beer beer) {
        beerRepository.save(beer);
        System.out.println(beer.toString());
    }
}
