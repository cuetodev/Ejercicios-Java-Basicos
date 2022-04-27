package com.cuetodev.ej3_1.Estudiante_Asignatura.application.port;

import com.cuetodev.ej3_1.Asignatura.domain.Asignatura;
import com.cuetodev.ej3_1.Estudiante.domain.Estudiante;
import com.cuetodev.ej3_1.Estudiante_Asignatura.domain.EstudianteAsignatura;
import com.cuetodev.ej3_1.Estudiante_Asignatura.infrastructure.controller.dto.input.EstudianteAsignaturaInputDTO;

import java.util.List;

public interface EstudianteAsignaturaPort {
    public EstudianteAsignatura addEstudianteAsignatura(EstudianteAsignaturaInputDTO estudianteAsignaturaInputDTO) throws Exception;
    public List<Asignatura> getAsignaturasByEstudianteID(String id_estudiante);
    public List<String> addEstudianteAsignaturaByListOfIDS(String id_estudiante, List<String> asignaturasIDS) throws Exception;
    public void deleteEstudianteAsignaturaByListOfIDS(String id_estudiante, List<String> asignaturasIDS) throws Exception;
}
