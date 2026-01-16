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

    @Column(nullable = false)
    private boolean favorite = false;

    public RestaurantsEntity() {}

    public RestaurantsEntity(String name, String country, String city, String cuisineType, double rating, List<String> reviews) {
        this.name = name;
        this.country = country;
        this.city = city;
        this.cuisineType = cuisineType;
        this.rating = rating;
        this.reviews = reviews;
        this.favorite = false; // explicit default
    }

// ADD GETTERS & SETTERS
public Long getId() { return id; }
public void setId(Long id) { this.id = id; }

public String getName() { return name; }
public void setName(String name) { this.name = name; }

public String getCountry() { return country; }
public void setCountry(String country) { this.country = country; }

public String getCity() { return city; }
public void setCity(String city) { this.city = city; }

public String getCuisineType() { return cuisineType; }
public void setCuisineType(String cuisineType) { this.cuisineType = cuisineType; }

public double getRating() { return rating; }
public void setRating(double rating) { this.rating = rating; }

public List<String> getReviews() { return reviews; }
public void setReviews(List<String> reviews) { this.reviews = reviews; }

public boolean isFavorite() { return favorite; }
public void setFavorite(boolean favorite) { this.favorite = favorite; }


}
