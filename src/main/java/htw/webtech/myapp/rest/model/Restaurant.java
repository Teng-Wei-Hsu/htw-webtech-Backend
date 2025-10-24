package htw.webtech.myapp.rest.model;


import java.util.List;

public class Restaurant {


    private Long id;
    private String name;
    private String country;
    private String city;
    private String cuisineType;
    private double rating;        // e.g., 4.5 stars
    private List<String> reviews; // e.g., ["Great food!", "Service was fast"]

    // Constructor
    public Restaurant(Long id, String name, String country, String city, String cuisineType, double rating, List<String> reviews) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.city = city;
        this.cuisineType = cuisineType;
        this.rating = rating;
        this.reviews = reviews;
    }

    // Getters (used by Spring to convert to JSON)
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public double getRating() {
        return rating;
    }

    public List<String> getReviews() {
        return reviews;
    }

}
