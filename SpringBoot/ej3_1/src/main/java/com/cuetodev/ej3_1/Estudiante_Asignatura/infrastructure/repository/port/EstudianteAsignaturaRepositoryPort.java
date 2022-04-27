package com.cuetodev.ej3_1.Estudiante_Asignatura.infrastructure.repository.port;

import com.cuetodev.ej3_1.Asignatura.domain.Asignatura;
import com.cuetodev.ej3_1.Estudiante_Asignatura.domain.EstudianteAsignatura;

import java.util.List;

public interface EstudianteAsignaturaRepositoryPort {
    public EstudianteAsignatura addEstudianteAsignatura(EstudianteAsignatura estudianteAsignatura);
    public List<EstudianteAsignatura> getAsignaturasByEstudianteID(String id_estudiante);
    public void addEstudianteAsignaturaByListOfIDS(List<EstudianteAsignatura> asignaturasList);
    public void deleteEstudianteAsignaturaByListOfIDS(List<EstudianteAsignatura> asignaturasList);
    public List<EstudianteAsignatura> getEstudianteAsignaturaByAsignaturaID(String asignaturaId, String estudianteId);
}
