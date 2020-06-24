package nl.inholland.myfirstbeerapi;

import nl.inholland.myfirstbeerapi.model.Beer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BeerTests
{
    @Test
    public void createGuitarShouldNotBeNull() {
        Beer beer = new Beer();
        assertNotNull(beer);
    }

}
