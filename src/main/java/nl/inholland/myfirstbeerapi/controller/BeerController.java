package nl.inholland.myfirstbeerapi.controller;

import nl.inholland.myfirstbeerapi.model.Beer;
import nl.inholland.myfirstbeerapi.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Controller
@RequestMapping("/api/beers")
public class BeerController
{

    @Autowired
    private BeerService beerService;

    // GET: Get all beers
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllBeers() {
        List<Beer> beers = beerService.getAllBeers();
        return ResponseEntity
                .status(200)
                .body(beers.toString());
    }

    // GET: Get all beers from a single brand
    @RequestMapping(value="", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, params = {"brand"})
    public ResponseEntity getAllBeers(@RequestParam("brand") String brand)
    {
        try
        {
            List<Beer> beers = beerService.getBeersByBrand(brand);
            return ResponseEntity
                    .status(200)
                    .body(beers.toString());
        }
        catch (IllegalArgumentException iae)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // GET: Get all beers at or below a certain price
    @RequestMapping(value="", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, params = {"maxPrice"})
    public ResponseEntity getAllBeers(@RequestParam("maxPrice") Integer maxPrice)
    {
        try
        {
            List<Beer> beers = beerService.getBeersAtOrBelowPrice(maxPrice);
            return ResponseEntity
                    .status(200)
                    .body(beers.toString());
        }
        catch (IllegalArgumentException iae)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createBeer(@RequestBody Beer beer) {
        beerService.addBeer(beer);
        return ResponseEntity.status(HttpStatus.CREATED).body(beer.getId());
    }
}
