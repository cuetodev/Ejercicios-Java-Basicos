package com.cuetodev.rs1.models;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImplemented implements PersonService {

    List<Person> peopleList = new ArrayList<>();

    @Override
    public List<Person> getPeople() {
        return this.peopleList;
    }

    @Override
    public void setPeople(List<Person> peopleList) {
        System.out.println(peopleList);
        this.peopleList = peopleList;
    }
}
