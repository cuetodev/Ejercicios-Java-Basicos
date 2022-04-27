package com.cuetodev.ej3_1.Profesor.infrastructure.repository.jpa;

import com.cuetodev.ej3_1.Profesor.domain.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProfesorRepositoryJPA extends JpaRepository<Profesor, String> {

    @Query("SELECT p FROM Profesor p")
    public List<Profesor> getAllPeople();

    @Transactional
    @Modifying
    @Query("DELETE Profesor e where e.id = ?1")
    public int deleteProfesor(String id_profesor);

    @Query("SELECT p FROM Profesor p where p.persona.id = ?1")
    public Optional<Profesor> findProfesorByPersonaID(Integer id_persona);
}
