package com.cuetodev.rs1.controllers;

import com.cuetodev.rs1.models.Person;
import com.cuetodev.rs1.models.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("persona")
public class ControllerPost {
    @Autowired
    PersonService personService;

    @PostMapping
    public ResponseEntity<String> personPost(@RequestBody Person person) {
        personService.getPeople().add(person);

        return new ResponseEntity<>("Person added", HttpStatus.OK);
    }
}
