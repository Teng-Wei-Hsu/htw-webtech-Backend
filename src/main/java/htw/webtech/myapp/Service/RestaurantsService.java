package htw.webtech.myapp.Service;

import htw.webtech.myapp.persistence.entity.RestaurantsEntity;
import htw.webtech.myapp.persistence.repository.RestaurantsRepo;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RestaurantsService {

    private final RestaurantsRepo repo;

    public RestaurantsService(RestaurantsRepo repo) {
        this.repo = repo;
    }

    public List<RestaurantsEntity> getAll() {
        return repo.findAll();
    }

    public RestaurantsEntity getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public RestaurantsEntity create(RestaurantsEntity entity) {
        entity.setFavorite(false); // enforce default
        return repo.save(entity);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    // NEW METHOD
    public RestaurantsEntity toggleFavorite(Long id) {
        RestaurantsEntity restaurant = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        restaurant.setFavorite(!restaurant.isFavorite());
        return repo.save(restaurant);
    }


}
