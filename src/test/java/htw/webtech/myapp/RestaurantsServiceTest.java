package htw.webtech.myapp;

import htw.webtech.myapp.Service.RestaurantsService;
import htw.webtech.myapp.persistence.entity.RestaurantsEntity;
import htw.webtech.myapp.persistence.repository.RestaurantsRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RestaurantsServiceTest {


    @Mock
    private RestaurantsRepo repo;

    @InjectMocks
    private RestaurantsService service;

    private RestaurantsEntity restaurant;

    @BeforeEach
    void setUp() {
        restaurant = new RestaurantsEntity(
                "Sushi Place", "Germany", "Berlin", "Japanese", 4.5, List.of("Great")
        );
        restaurant.setFavorite(false);
    }

    @Test
    void testGetAllRestaurants() {
        when(repo.findAll()).thenReturn(List.of(restaurant));

        List<RestaurantsEntity> result = service.getAll();

        assertEquals(1, result.size());
    }

    @Test
    void testGetById() {
        when(repo.findById(1L)).thenReturn(Optional.of(restaurant));

        RestaurantsEntity result = service.getById(1L);

        assertNotNull(result);
    }

    @Test
    void testCreate() {
        when(repo.save(any())).thenReturn(restaurant);

        RestaurantsEntity saved = service.create(restaurant);

        assertEquals("Sushi Place", saved.getName());
    }

    @Test
    void testDelete() {
        doNothing().when(repo).deleteById(1L);

        service.delete(1L);

        verify(repo).deleteById(1L);
    }

    @Test
    void testToggleFavorite() {
        when(repo.findById(1L)).thenReturn(Optional.of(restaurant));
        when(repo.save(any(RestaurantsEntity.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        RestaurantsEntity updated = service.toggleFavorite(1L);

        assertTrue(updated.isFavorite());
        verify(repo).save(restaurant);
    }

    @Test
    void testUpdateRestaurant() {
        // existing restaurant in DB
        when(repo.findById(1L)).thenReturn(Optional.of(restaurant));
        when(repo.save(any(RestaurantsEntity.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        // updated values (ONLY editable fields)
        RestaurantsEntity updatedData = new RestaurantsEntity(
                "IGNORED",          // name ignored
                "IGNORED",          // country ignored
                "IGNORED",          // city ignored
                "Thai",             // cuisine updated
                4.9,                // rating updated
                List.of("Amazing")  // reviews updated
        );
        updatedData.setFavorite(true);

        RestaurantsEntity result = service.update(1L, updatedData);

        assertEquals("Thai", result.getCuisineType());
        assertEquals(4.9, result.getRating());
        assertEquals(List.of("Amazing"), result.getReviews());
        assertTrue(result.isFavorite());

        // ensure immutable fields remain unchanged
        assertEquals("Sushi Place", result.getName());
        assertEquals("Germany", result.getCountry());
        assertEquals("Berlin", result.getCity());
    }
}
