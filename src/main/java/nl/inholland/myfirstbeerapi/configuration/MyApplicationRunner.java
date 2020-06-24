package nl.inholland.myfirstbeerapi.configuration;

import nl.inholland.myfirstbeerapi.dao.BeerRepository;
import nl.inholland.myfirstbeerapi.dao.StockRepository;
import nl.inholland.myfirstbeerapi.model.Beer;
import nl.inholland.myfirstbeerapi.model.Config;
import nl.inholland.myfirstbeerapi.model.Stock;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
@ConditionalOnProperty(prefix="beershop.autorun", name="enabled", havingValue="true", matchIfMissing = true)
@Transactional
public class MyApplicationRunner implements ApplicationRunner
{
    private BeerRepository beerRepository;
    private StockRepository stockRepository;
    private Config config;

    public MyApplicationRunner(BeerRepository beerRepository, StockRepository stockRepository, Config config)
    {
        this.beerRepository = beerRepository;
        this.stockRepository = stockRepository;
        this.config = config;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception
    {
        // Create a new list of beers
        List<Beer> beers =
                Arrays.asList(
                        new Beer(1L,"Jopen", "Mooie Nel IPA", 3),
                        new Beer(2l, "Jopen", "Gelovige Thomas", 2),
                        new Beer(3L, "Brouwerij 't IJ", "Eiwit", 4));
        // Save these beers using the repository
        beers.forEach(beerRepository::save);
        // Print all of the beers to the console
        beerRepository.findAll().forEach(System.out::println);
        // Get all beers and set a stock amount for them
        beerRepository
                .findAll()
                .forEach(beer -> stockRepository.save(new Stock(beer, new Random().nextInt(100))));
        // Print the entire beer stock
        stockRepository.findAll().forEach(System.out::println);
        // Get the entire stock which has an amount of 30 or greater
        Iterable<Stock> stocks = stockRepository.getAllByQuantityGreaterThanEqualOrderByQuantity(30);
        // Print te entire stock
        stocks.forEach(System.out::println);

        // Get the list of beers and create a new stock for each
        List<Beer> beersList = (List<Beer>) beerRepository.findAll();
        beersList.stream()
                .forEach(beer -> stockRepository
                        .save(new Stock(beer, config.getQuantity())));
    }
}
