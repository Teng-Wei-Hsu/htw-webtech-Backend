package htw.webtech.myapp.rest.controller;


import htw.webtech.myapp.Service.RestaurantsService;
import htw.webtech.myapp.persistence.entity.RestaurantsEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
    @CrossOrigin(origins = {"https://htw-webtech-frontend-x6d1.onrender.com","http://localhost:5173"})

@RequestMapping("/restaurants")
public class Controller {

    private final RestaurantsService service;

    public Controller(RestaurantsService service) {
        this.service = service;
    }

    // GET all restaurants
    @GetMapping
    public List<RestaurantsEntity> getAllRestaurants() {
        return service.getAll();
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
    @DeleteMapping("/{id}")
    public void deleteRestaurant(@PathVariable Long id) {
        service.delete(id);
    }

    //NEW FAVORITE TOGGLE ENDPOINT
    @PatchMapping("/{id}/favorite")
    public RestaurantsEntity toggleFavorite(@PathVariable Long id) {
        return service.toggleFavorite(id);
    }

    //NEW updateRestaurant ENDPOINT for editing
    @PutMapping("/{id}")
    public RestaurantsEntity updateRestaurant(
            @PathVariable Long id,
            @RequestBody RestaurantsEntity restaurant
    ) {
        return service.update(id, restaurant);
    }


}
