package com.example.moviecharacterapi.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String alias;

    private String gender;

    private String picture;

    @ManyToMany(mappedBy = "characters")
    private List<Movie> movies;

}
