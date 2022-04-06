package com.cuetodev.rs1.models;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PersonService {
    List<Person> getPeople();
    void setPeople(List<Person> peopleList);
}
