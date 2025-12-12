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
        return repo.save(entity);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
