package com.docker.docker_testconnection_postgre;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepositoryJPA extends JpaRepository<Person, Integer> {
}
