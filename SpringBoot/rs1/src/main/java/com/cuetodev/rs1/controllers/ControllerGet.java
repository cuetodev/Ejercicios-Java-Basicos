package com.cuetodev.rs1.controllers;

import com.cuetodev.rs1.models.Person;
import com.cuetodev.rs1.models.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("persona")
public class ControllerGet {
    @Autowired
    PersonService personService;

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable int id) {
        for (Person person: personService.getPeople()) {
            if (person.getId() == id) return new ResponseEntity<>(person, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Person> getPersonById(@PathVariable String name) {
        for (Person person: personService.getPeople()) {
            if (person.getName().equals(name)) return new ResponseEntity<>(person, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
