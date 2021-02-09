package com.example.moviecharacterapi.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Franchise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String description;

    @OneToMany(mappedBy = "franchise")
    private List<Movie> movies;
}
