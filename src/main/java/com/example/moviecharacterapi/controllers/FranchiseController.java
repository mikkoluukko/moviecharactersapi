package com.example.moviecharacterapi.controllers;

import com.example.moviecharacterapi.models.Character;
import com.example.moviecharacterapi.models.Franchise;
import com.example.moviecharacterapi.models.Movie;
import com.example.moviecharacterapi.repositories.FranchiseRepository;
import com.example.moviecharacterapi.services.FranchiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/franchises")
public class FranchiseController {

    @Autowired
    private FranchiseRepository franchiseRepository;

    @Autowired
    private FranchiseService franchiseService;

    @GetMapping()
    public ResponseEntity<List<Franchise>> getAllFranchises() {
        List<Franchise> franchises = franchiseRepository.findAll();
        HttpStatus status = HttpStatus.OK;
        return new ResponseEntity<>(franchises, status);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Franchise> getFranchise(@PathVariable Long id) {
        Franchise returnFranchise = new Franchise();
        HttpStatus status;
        if (franchiseRepository.existsById(id)) {
            status = HttpStatus.OK;
            returnFranchise = franchiseRepository.findById(id).get();
        } else {
            status = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>(returnFranchise, status);
    }

    // Get all the movies in a franchise
    @GetMapping("/{id}/movies")
    public ResponseEntity<List<Movie>> getMoviesInFranchise(@PathVariable Long id) {
        List<Movie> moviesInFranchise = new ArrayList<>();
        HttpStatus status;
        if (franchiseRepository.existsById(id)) {
            status = HttpStatus.OK;
            moviesInFranchise = franchiseService.getMoviesInFranchise(id);
        } else {
            status = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>(moviesInFranchise, status);
    }

    // Get all the characters in a franchise
    @GetMapping("/{id}/characters")
    public ResponseEntity<Set<Character>> getCharactersInFranchise(@PathVariable Long id) {
        Set<Character> charactersInFranchise = new HashSet<>();
        HttpStatus status;
        if (franchiseRepository.existsById(id)) {
            status = HttpStatus.OK;
            charactersInFranchise = franchiseService.getCharactersInFranchise(id);
        } else {
            status = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>(charactersInFranchise, status);
    }

    @PostMapping
    public ResponseEntity<Franchise> addFranchise(@RequestBody Franchise franchise) {
        Franchise returnFranchise = franchiseRepository.save(franchise);
        HttpStatus status = HttpStatus.CREATED;
        return new ResponseEntity<>(returnFranchise, status);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Franchise> updateFranchise(@PathVariable Long id, @RequestBody Franchise franchise) {
        Franchise returnFranchise = new Franchise();
        HttpStatus status;
        /*
         We want to check if the request body matches what we see in the path variable.
         This is to ensure some level of security, making sure someone
         hasn't done some malicious stuff to our body.
        */
        if (!id.equals(franchise.getId())) {
            status = HttpStatus.BAD_REQUEST;
            return new ResponseEntity<>(returnFranchise,status);
        }
        returnFranchise = franchiseRepository.save(franchise);
        status = HttpStatus.NO_CONTENT;
        return new ResponseEntity<>(returnFranchise, status);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteFranchise(@PathVariable Long id) {
        HttpStatus status;
        if (franchiseRepository.existsById(id)) {
            status = HttpStatus.OK;
            franchiseRepository.deleteById(id);
        } else {
            status = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>(status);
    }
}
