package nl.inholland.myfirstbeerapi.configuration;

import nl.inholland.myfirstbeerapi.dao.BeerRepository;
import nl.inholland.myfirstbeerapi.dao.StockRepository;
import nl.inholland.myfirstbeerapi.model.Beer;
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

    public MyApplicationRunner(BeerRepository beerRepository, StockRepository stockRepository)
    {
        this.beerRepository = beerRepository;
        this.stockRepository = stockRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception
    {
        List<Beer> beers =
                Arrays.asList(
                        new Beer(1L,"Jopen", "Mooie Nel IPA", 3),
                        new Beer(2l, "Jopen", "Gelovige Thomas", 2),
                        new Beer(3L, "Brouwerij 't IJ", "Eiwit", 4));

        beers.forEach(beerRepository::save);

        beerRepository.findAll().forEach(System.out::println);

        beerRepository
                .findAll()
                .forEach(beer -> stockRepository.save(new Stock(new Random().nextInt(100), beer)));

        stockRepository.findAll().forEach(System.out::println);

        Iterable<Stock> stocks = stockRepository.getAllByQuantityGreaterThanEqualOrderByQuantity(30);
        stocks.forEach(System.out::println);

        int quantity = stockRepository.getStockValueByBeerId(1000001L);
        System.out.println("Quantity: " + quantity);
    }
}
