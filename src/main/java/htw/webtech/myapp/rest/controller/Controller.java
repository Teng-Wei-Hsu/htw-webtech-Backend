package htw.webtech.myapp.rest.controller;


import htw.webtech.myapp.rest.model.Restaurant;
import htw.webtech.myapp.Service.RestaurantsService;
import htw.webtech.myapp.persistence.entity.RestaurantsEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
    @CrossOrigin(origins = {"https://htw-webtech-frontend-x6d1.onrender.com","http://localhost:5173"})
public class Controller {

    private final RestaurantsService service;

    public Controller(RestaurantsService service) {
        this.service = service;
    }

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

    // GET one by ID
    @GetMapping("/{id}")
    public RestaurantsEntity getOne(@PathVariable Long id) {
        return service.getById(id);
    }

    // POST new restaurant
    @PostMapping
    public RestaurantsEntity createRestaurant(@RequestBody RestaurantsEntity restaurant) {
        return service.create(restaurant);
    }

    //PUT und DELETE und Frontend Placeholder for add and delete restaurants in the list

}
