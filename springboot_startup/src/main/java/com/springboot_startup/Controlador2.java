package com.springboot_startup;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador2 {

    @PostMapping("/useradd")
    public Person incrementAgeBy1(@RequestBody Person person) {
        person.setAge(person.getAge() + 1);
        return person;
    }
}
