package com.cuetodev.db1.Persona.infrastructure.repository.jpa;

import com.cuetodev.db1.Persona.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface PersonaRepositoryJPA extends JpaRepository<Persona, Integer> {

    @Query("SELECT p FROM Persona p where p.usuario like ?1")
    public List<Persona> findPersonaByUsuario(String usuario);

    @Query("SELECT p FROM Persona p")
    public List<Persona> getAllPeople();

    @Transactional
    @Modifying
    @Query("DELETE Persona p where p.id = ?1")
    public int deletePerson(int id); // Devuelve un entero porque devuelve el número de resultados afectados por la consulta
}
