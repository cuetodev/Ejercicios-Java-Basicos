package com.docker.docker_testconnection_postgre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class PersonController {
    // Recordar que esto simplemente es una prueba
    @Autowired
    PersonRepository personRepository;

    @GetMapping("person/{id}")
    public ResponseEntity<?> getPerson(@PathVariable Integer id) {
        Optional<Person> personOptional = personRepository.findById(id);
        if (personOptional.isEmpty()) return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(personOptional.get(), HttpStatus.OK);
    }
}
