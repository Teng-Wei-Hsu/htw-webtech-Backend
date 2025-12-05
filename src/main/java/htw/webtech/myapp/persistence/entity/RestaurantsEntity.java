package htw.webtech.myapp.persistence.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "restaurants")


public class RestaurantsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String country;
    private String city;
    private String cuisineType;
    private double rating;

    @ElementCollection
    private List<String> reviews;

    public RestaurantsEntity() {}

    public RestaurantsEntity(String name, String country, String city, String cuisineType, double rating, List<String> reviews) {
        this.name = name;
        this.country = country;
        this.city = city;
        this.cuisineType = cuisineType;
        this.rating = rating;
        this.reviews = reviews;
    }

}
