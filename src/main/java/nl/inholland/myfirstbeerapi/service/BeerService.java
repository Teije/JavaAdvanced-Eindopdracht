package nl.inholland.myfirstbeerapi.service;

import nl.inholland.myfirstbeerapi.model.Beer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class BeerService {

    List<Beer> beers;

    public BeerService() {

        this.beers =  Arrays.asList(
                new Beer(1L,"Jopen", "Mooie Nel IPA", 3),
                new Beer(2l, "Jopen", "Gelovige Thomas", 2),
                new Beer(3L, "Brouwerij 't IJ", "Eiwit", 4)
        );
    }

    public List<Beer> getAllBeers() {
        return beers;
    }

    // Return all beers from the supplied brand
    public List<Beer> getBeersByBrand(String brand)
    {
        var result = new ArrayList<Beer>();

        for (var beer: beers)
        {
            if(beer.getBrand().toLowerCase().equals(brand.toLowerCase()))
            {
                result.add(beer);
            }
        }
        return result;
    }

    public List<Beer> getBeersAtOrBelowPrice(Integer price)
    {
        var result = new ArrayList<Beer>();

        for (var beer: beers)
        {
            if(beer.getPrice() <= price)
            {
                result.add(beer);
            }
        }
        return result;
    }
}
