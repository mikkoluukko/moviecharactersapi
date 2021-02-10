package com.example.moviecharacterapi.models;

import com.fasterxml.jackson.annotation.JsonGetter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String title;

    private String genre;

    private String releaseyear;

    private String director;

    private String picture;

    private String trailer;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "movies", fetch = FetchType.LAZY)
    private Set<Character> characters;

    @JsonGetter("characters")
    public List<String> charactersGetter() {
        if(characters != null) {
            return characters.stream()
                    .map(character -> {
                        return "/api/v1/characters/" + character.getId();
                    }).collect(Collectors.toList());
        }
        return null;
    }

    @ManyToOne
    @JoinColumn(name = "franchise_id")
    private Franchise franchise;

    @JsonGetter("franchise")
    public String franchiseGetter() {
        if (franchise != null) {
            return "/api/v1/franchises/" + franchise.getId();
        } else {
            return null;
        }
    }

    public Movie() {

    }

    public Movie(String title, String genre, String releaseyear, String director) {
        this.title = title;
        this.genre = genre;
        this.releaseyear = releaseyear;
        this.director = director;
    }

    public Movie(String title, String genre, String releaseyear, String director, Franchise franchise) {
        this.title = title;
        this.genre = genre;
        this.releaseyear = releaseyear;
        this.director = director;
        this.picture = picture;
        this.franchise = franchise;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getReleaseyear() {
        return releaseyear;
    }

    public void setReleaseyear(String releaseyear) {
        this.releaseyear = releaseyear;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public void setFranchise(Franchise franchise) {
        this.franchise = franchise;
    }

    public void setCharacters(Set<Character> characters) {
        this.characters = characters;
    }

    public Set<Character> getCharacters() {
        return characters;
    }
}
