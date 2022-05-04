package com.docker.docker_testconnection_postgre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonRepository {
    @Autowired
    PersonRepositoryJPA personRepositoryJPA;

    public Optional<Person> findById(Integer id) {
        return personRepositoryJPA.findById(id);
    }
}
