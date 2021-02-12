package com.example.moviecharacterapi.models;

import com.fasterxml.jackson.annotation.JsonGetter;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Franchise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    private String description;

//    @OneToMany(mappedBy = "franchise")
    @OneToMany
    @JoinColumn(name = "franchise_id")
    List<Movie> movies;

    @JsonGetter("movies")
    public List<String> moviesGetter() {
        if(movies != null) {
            return movies.stream()
                    .map(character -> {
                        return "/api/v1/movies/" + character.getId();
                    }).collect(Collectors.toList());
        }
        return null;
    }


    public Franchise() {

    }

    //    Used in the DatabaseSeeder
    public Franchise(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
