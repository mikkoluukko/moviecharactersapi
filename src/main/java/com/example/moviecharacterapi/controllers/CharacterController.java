package com.example.moviecharacterapi.controllers;

import com.example.moviecharacterapi.models.Character;
import com.example.moviecharacterapi.repositories.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/characters")
public class CharacterController {

    @Autowired
    private CharacterRepository characterRepository;

    @GetMapping()
    public ResponseEntity<List<Character>> getAllCharacters() {
        List<Character> characters = characterRepository.findAll();
        HttpStatus status = HttpStatus.OK;
        return new ResponseEntity<>(characters, status);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Character> getCharacter(@PathVariable Long id) {
        Character returnCharacter = new Character();
        HttpStatus status;
        if (characterRepository.existsById(id)) {
            status = HttpStatus.OK;
            returnCharacter = characterRepository.findById(id).get();
        } else {
            status = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>(returnCharacter, status);

    }

    @PostMapping
    public ResponseEntity<Character> addCharacter(@RequestBody Character character) {
        Character returnCharacter = characterRepository.save(character);
        HttpStatus status = HttpStatus.CREATED;
        return new ResponseEntity<>(returnCharacter, status);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Character> updateCharacter(@PathVariable Long id, @RequestBody Character character) {
        Character returnCharacter = new Character();
        HttpStatus status;
        /*
         We want to check if the request body matches what we see in the path variable.
         This is to ensure some level of security, making sure someone
         hasn't done some malicious stuff to our body.
        */
        if (!id.equals(character.getId())) {
            status = HttpStatus.BAD_REQUEST;
            return new ResponseEntity<>(returnCharacter,status);
        }
        returnCharacter = characterRepository.save(character);
        status = HttpStatus.NO_CONTENT;
        return new ResponseEntity<>(returnCharacter, status);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCharacter(@PathVariable Long id) {
        HttpStatus status;
        if (characterRepository.existsById(id)) {
            status = HttpStatus.OK;
            characterRepository.deleteById(id);
        } else {
            status = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>(status);
    }
}
