package nl.inholland.myfirstbeerapi;

import nl.inholland.myfirstbeerapi.model.Beer;
import nl.inholland.myfirstbeerapi.service.BeerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;


import java.util.Arrays;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class BeerControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private BeerService service;

    private Beer beer;

    @BeforeEach
    public void setup() {
        beer = new Beer(5L,"Heineken", "0.0%", 3);
    }

    @Test
    public void getAllBeersShouldReturnJsonArray() throws Exception {
        given(service.getAllBeers()).willReturn(Arrays.asList(beer));
        this.mvc.perform(get("/beers")).andExpect(
                status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].brand").value(beer.getBrand()));
    }

    @Test
    public void whenAddBeerShouldReturnCreated() throws Exception {
        mvc.perform(post("/beers")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content("{}"))
                .andExpect(status().isCreated());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addBeer(@RequestBody Beer beer) {
        service.addBeer(beer);
    }
}
