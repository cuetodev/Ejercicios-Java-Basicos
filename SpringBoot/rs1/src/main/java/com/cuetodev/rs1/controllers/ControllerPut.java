package com.cuetodev.rs1.controllers;

import com.cuetodev.rs1.models.Person;
import com.cuetodev.rs1.models.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("persona")
public class ControllerPut {
    @Autowired
    PersonService personService;

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePerson(@PathVariable int id, @RequestBody Person person) {
        for (Person personIterable : personService.getPeople()) {
            if (personIterable.getId() == id) {

                if(person.getName() != null ) {
                    personIterable.setName(person.getName());
                }

                if (person.getPopulation() != null) {
                    personIterable.setPopulation(person.getPopulation());
                }

                if (person.getAge() != null && person.getAge() != 0) {
                    personIterable.setPopulation(person.getPopulation());
                }

                return new ResponseEntity<>("Person modified", HttpStatus.OK);

            }
        }
        return new ResponseEntity<>("Person not found", HttpStatus.NOT_FOUND);
    }

}
