package com.cuetodev.ej3_1.Estudiante_Asignatura.infrastructure.repository.jpa;

import com.cuetodev.ej3_1.Estudiante.domain.Estudiante;
import com.cuetodev.ej3_1.Estudiante_Asignatura.domain.EstudianteAsignatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EstudianteAsignaturaRepositoryJPA extends JpaRepository<EstudianteAsignatura, String> {
    @Query("SELECT a from EstudianteAsignatura a where a.estudiante.id_estudiante = ?1")
    public List<EstudianteAsignatura> getAsignaturasByEstudianteID(String id_estudiante);

    @Query("SELECT a from EstudianteAsignatura a where a.asignatura.id_asignatura = ?1 AND a.estudiante.id_estudiante = ?2")
    public List<EstudianteAsignatura> getEstudianteAsignaturaByAsignaturaID(String id_asignatura, String id_estudiante);
}
