package com.example.moviecharacterapi.repositories;

import com.example.moviecharacterapi.models.Character;
import com.example.moviecharacterapi.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Long> {
    List<Character> findAllByMovies(Movie movie);
}
