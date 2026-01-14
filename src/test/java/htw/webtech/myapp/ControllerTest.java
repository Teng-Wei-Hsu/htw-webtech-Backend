package htw.webtech.myapp;

import com.fasterxml.jackson.databind.ObjectMapper;
import htw.webtech.myapp.Service.RestaurantsService;
import htw.webtech.myapp.persistence.entity.RestaurantsEntity;
import htw.webtech.myapp.rest.controller.Controller;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;









@WebMvcTest(Controller.class)
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RestaurantsService service;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getAllRestaurants_shouldReturnList() throws Exception {
        RestaurantsEntity restaurant = new RestaurantsEntity(
                "Sushi Palace", "Germany", "Berlin", "Japanese", 4.8, List.of("Great!")
        );

        Mockito.when(service.getAll()).thenReturn(List.of(restaurant));

        mockMvc.perform(get("/restaurants"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Sushi Palace"));
    }

    @Test
    void getRestaurantById_shouldReturnRestaurant() throws Exception {
        RestaurantsEntity restaurant = new RestaurantsEntity(
                "La Piazza", "Germany", "Munich", "Italian", 4.6, List.of("Nice")
        );

        Mockito.when(service.getById(1L)).thenReturn(restaurant);

        mockMvc.perform(get("/restaurants/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("La Piazza"));
    }

    @Test
    void createRestaurant_shouldReturnCreatedRestaurant() throws Exception {
        RestaurantsEntity restaurant = new RestaurantsEntity(
                "Burger Bros", "Germany", "Hamburg", "American", 4.5, List.of("Good")
        );

        Mockito.when(service.create(Mockito.any())).thenReturn(restaurant);

        mockMvc.perform(post("/restaurants")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(restaurant)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Burger Bros"));
    }

    @Test
    void deleteRestaurant_shouldReturnOk() throws Exception {
        mockMvc.perform(delete("/restaurants/1"))
                .andExpect(status().isOk());
    }

    @Test
    void toggleFavorite_shouldReturnUpdatedRestaurant() throws Exception {
        RestaurantsEntity restaurant = new RestaurantsEntity(
                "Sushi Palace", "Germany", "Berlin", "Japanese", 4.8, List.of("Great!")
        );
        restaurant.setFavorite(true);

        Mockito.when(service.toggleFavorite(1L)).thenReturn(restaurant);

        mockMvc.perform(patch("/restaurants/1/favorite"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.favorite").value(true));
    }


}
