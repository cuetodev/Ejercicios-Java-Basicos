package com.cuetodev.ej3_1.Estudiante.infrastructure.repository.jpa;

import com.cuetodev.ej3_1.Estudiante.domain.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface EstudianteRepositoryJPA extends JpaRepository<Estudiante, String> {

    @Query("SELECT e FROM Estudiante e")
    public List<Estudiante> getAllPeople();

    @Transactional
    @Modifying
    @Query("DELETE Estudiante e where e.id = ?1")
    public int deleteEstudiante(String id);

    @Query("SELECT e FROM Estudiante e where e.persona.id = ?1")
    public Optional<Estudiante> findEstudianteByPersonaID(Integer id_persona);
}
