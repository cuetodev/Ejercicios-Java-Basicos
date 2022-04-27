package com.cuetodev.ej3_1.Estudiante.application.port;

import com.cuetodev.ej3_1.Estudiante.domain.Estudiante;
import com.cuetodev.ej3_1.Estudiante.infrastructure.controller.dto.input.EstudianteInputDTO;
import com.cuetodev.ej3_1.Profesor.domain.Profesor;

import java.util.Optional;

public interface EstudiantePort {
    public Estudiante insertEstudiante(EstudianteInputDTO estudiante) throws Exception;
    public Estudiante findEstudianteById(String id) throws Exception;
    public Optional<Estudiante> findEstudianteByPersonID(Integer id_persona);
    public Optional<Profesor> findProfesorByPersonID(Integer id_persona);
}
