package com.cuetodev.rs1.controllers;

import com.cuetodev.rs1.models.Person;
import com.cuetodev.rs1.models.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("persona")
public class ControllerDelete {

    @Autowired
    PersonService personService;

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable int id) {
        List<Person> peopleListTemp = personService.getPeople().stream().filter(person -> person.getId() != id).collect(Collectors.toList());
        personService.setPeople(peopleListTemp);

        return new ResponseEntity<>("Person deleted", HttpStatus.OK);
    }
}
