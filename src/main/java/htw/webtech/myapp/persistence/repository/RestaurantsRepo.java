package htw.webtech.myapp.persistence.repository;

import htw.webtech.myapp.persistence.entity.RestaurantsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantsRepo extends JpaRepository<RestaurantsEntity, Long> {
}
