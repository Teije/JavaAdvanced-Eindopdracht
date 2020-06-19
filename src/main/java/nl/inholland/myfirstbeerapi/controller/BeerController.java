package nl.inholland.myfirstbeerapi.controller;

import nl.inholland.myfirstbeerapi.model.Beer;
import nl.inholland.myfirstbeerapi.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
@RequestMapping("beers")
public class BeerController
{

    @Autowired
    private BeerService service;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllBeers() {
        List<Beer> beers = service.getAllBeers();
        return ResponseEntity
                .status(200)
                .body(beers);
    }
}
