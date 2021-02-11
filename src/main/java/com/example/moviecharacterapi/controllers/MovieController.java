package com.example.moviecharacterapi.controllers;

import com.example.moviecharacterapi.models.Character;
import com.example.moviecharacterapi.models.Movie;
import com.example.moviecharacterapi.repositories.MovieRepository;
import com.example.moviecharacterapi.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieService movieService;

    @GetMapping()
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> movies = movieRepository.findAll();
        HttpStatus status = HttpStatus.OK;
        return new ResponseEntity<>(movies, status);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable Long id) {
        Movie returnMovie = new Movie();
        HttpStatus status;
        // We first check if the author exists, this saves some computing time.
        if (movieRepository.existsById(id)) {
            status = HttpStatus.OK;
            returnMovie = movieRepository.findById(id).get();
        } else {
            status = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>(returnMovie, status);
    }

    // Get all characters in a movie
    @GetMapping("/{id}/characters")
    public ResponseEntity<List<Character>> getCharactersInMovie(@PathVariable Long id) {
        List<Character> charactersInMovie = new ArrayList<>();
        HttpStatus status;
        if (movieRepository.existsById(id)) {
            status = HttpStatus.OK;
            charactersInMovie = movieService.getCharactersInMovie(id);
        } else {
            status = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>(charactersInMovie, status);
    }

    @PostMapping
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        Movie returnMovie = movieRepository.save(movie);
        HttpStatus status = HttpStatus.CREATED;
        return new ResponseEntity<>(returnMovie, status);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody Movie movie) {
        Optional<Movie> movieData = movieRepository.findById(id);
        if (movieData.isPresent()) {
            Movie _movie = movieData.get();
            _movie.setTitle(movie.getTitle());
            _movie.setGenre(movie.getGenre());
            _movie.setReleaseYear(movie.getReleaseYear());
            _movie.setDirector(movie.getDirector());
            _movie.setPicture(movie.getPicture());
            _movie.setTrailer(movie.getTrailer());
            _movie.setFranchise(movie.getFranchise());
            _movie.setCharacters(movie.getCharacters());
            return new ResponseEntity<>(movieRepository.save(_movie), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteMovie(@PathVariable Long id) {
        HttpStatus status;
        // We first check if the movie exists, this saves some computing time.
        if (movieRepository.existsById(id)) {
            status = HttpStatus.OK;
            movieRepository.deleteById(id);
        } else {
            status = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>(status);
    }
}