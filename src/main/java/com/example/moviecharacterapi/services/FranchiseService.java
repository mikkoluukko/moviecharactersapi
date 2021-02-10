package com.example.moviecharacterapi.services;

import com.example.moviecharacterapi.models.Character;
import com.example.moviecharacterapi.models.Franchise;
import com.example.moviecharacterapi.models.Movie;
import com.example.moviecharacterapi.repositories.CharacterRepository;
import com.example.moviecharacterapi.repositories.FranchiseRepository;
import com.example.moviecharacterapi.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class FranchiseService {
    @Autowired
    private FranchiseRepository franchiseRepository;

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getMoviesInFranchise(Long id) {
        Franchise returnFranchise = franchiseRepository.findById(id).get();
        return movieRepository.findAllByFranchise(returnFranchise);
    }

    public Set<Character> getCharactersInFranchise(Long id) {
        List<Movie> moviesInFranchise;
        Set<Character> charactersInFranchise = new HashSet<>();
        Franchise returnFranchise = franchiseRepository.findById(id).get();
        moviesInFranchise = movieRepository.findAllByFranchise(returnFranchise);
        for (Movie movie : moviesInFranchise) {
            Set<Character> charactersInMovie = movie.getCharacters();
            for (Character character : charactersInMovie) {
                charactersInFranchise.add(character);
            }
        }
        return charactersInFranchise;
    }
}
