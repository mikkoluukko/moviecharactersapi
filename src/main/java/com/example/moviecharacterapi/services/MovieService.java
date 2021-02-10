package com.example.moviecharacterapi.services;

import com.example.moviecharacterapi.models.Character;
import com.example.moviecharacterapi.models.Movie;
import com.example.moviecharacterapi.repositories.CharacterRepository;
import com.example.moviecharacterapi.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private CharacterRepository characterRepository;

    public List<Character> getCharactersInMovie(Long id) {
        Movie returnMovie = movieRepository.findById(id).get();
        return characterRepository.findAllByMovies(returnMovie);
    }
}
