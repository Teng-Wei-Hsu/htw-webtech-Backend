package htw.webtech.myapp.rest.controller;


import htw.webtech.myapp.rest.model.Restaurant;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class Controller {

    @GetMapping("/restaurants")
    public List<Restaurant> getRestaurants() {
        // Return a few example restaurants
        return List.of(
                new Restaurant(
                        1L,
                        "Sushi Palace",
                        "Germany",
                        "Berlin",
                        "Japanese",
                        4.8,
                        List.of("Fresh fish!", "Beautiful decor")
                ),
                new Restaurant(
                        2L,
                        "La Piazza",
                        "Germany",
                        "Munich",
                        "Italian",
                        4.6,
                        List.of("Authentic pizza!", "Friendly staff")
                ),
                new Restaurant(
                        3L,
                        "Burger Bros",
                        "Germany",
                        "Hamburg",
                        "American",
                        4.5,
                        List.of("Great burgers!", "Nice location")
                )
        );
    }

}
