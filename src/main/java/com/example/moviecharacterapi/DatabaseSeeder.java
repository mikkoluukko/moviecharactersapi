package com.example.moviecharacterapi;

import com.example.moviecharacterapi.models.Character;
import com.example.moviecharacterapi.models.CommonResponse;
import com.example.moviecharacterapi.models.Franchise;
import com.example.moviecharacterapi.models.Movie;
import com.example.moviecharacterapi.repositories.CharacterRepository;
import com.example.moviecharacterapi.repositories.FranchiseRepository;
import com.example.moviecharacterapi.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/populate-database")
public class DatabaseSeeder {

    @Autowired
    private FranchiseRepository franchiseRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private CharacterRepository characterRepository;

    @PostMapping("")
    public ResponseEntity<HttpStatus> populateFranchises() {
        Franchise franchise1 = new Franchise("The Lord of the Rings", "The Lord of the Rings movies");
        Franchise franchise2 = new Franchise("James Bond", "James Bond movies");
        Movie movie1 = new Movie("The Fellowship of the Ring", "Fantasy, Adventure", "2001",
                "Peter Jackson", franchise1);
        Movie movie2 = new Movie("The Two Towers", "Fantasy, Adventure", "2002",
                "Peter Jackson", franchise1);
        Movie movie3 = new Movie("The Return of the King", "Fantasy, Adventure", "2003",
                "Peter Jackson", franchise1);
        Movie movie4 = new Movie("Dr. No", "Action, Adventure", "1962",
                "Terence Young", franchise2);
        Movie movie5 = new Movie("The Spy Who Loved Me", "Action, Spy", "1977",
                "Lewis Gilbert", franchise2);
        Movie movie6 = new Movie("Moonraker", "Action, Adventure", "1979",
                "Lewis Gilbert", franchise2);
        Movie movie7 = new Movie("Goldeneye", "Action, Adventure", "1995",
                "Martin Campbell", franchise2);
        Set<Movie> movies1 = new HashSet<>();
        movies1.add(movie1);
        movies1.add(movie2);
        movies1.add(movie3);
        Character character1 = new Character("Frodo Baggins", "Mr. Underhill", "Male",
                movies1);
        Character character2 = new Character("Gollum", "Smeagol", "Male",
                Stream.of(movie1, movie2, movie3).collect(Collectors.toSet()));
        Character character3 = new Character("James Bond", "007", "Male",
                Stream.of(movie4, movie5, movie6, movie7).collect(Collectors.toSet()));
        Character character4 = new Character("Jaws", "", "Male",
                Stream.of(movie5, movie6).collect(Collectors.toSet()));
        franchiseRepository.save(franchise1);
        franchiseRepository.save(franchise2);
        movieRepository.save(movie1);
        movieRepository.save(movie2);
        movieRepository.save(movie3);
        movieRepository.save(movie4);
        movieRepository.save(movie5);
        movieRepository.save(movie6);
        movieRepository.save(movie7);
        characterRepository.save(character1);
        characterRepository.save(character2);
        characterRepository.save(character3);
        characterRepository.save(character4);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
