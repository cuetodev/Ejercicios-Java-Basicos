package com.cuetodev.ej3_1.Estudiante_Asignatura.infrastructure.repository;

import com.cuetodev.ej3_1.Asignatura.domain.Asignatura;
import com.cuetodev.ej3_1.Estudiante_Asignatura.domain.EstudianteAsignatura;
import com.cuetodev.ej3_1.Estudiante_Asignatura.infrastructure.repository.jpa.EstudianteAsignaturaRepositoryJPA;
import com.cuetodev.ej3_1.Estudiante_Asignatura.infrastructure.repository.port.EstudianteAsignaturaRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteAsignaturaRepository implements EstudianteAsignaturaRepositoryPort {
    @Autowired
    EstudianteAsignaturaRepositoryJPA estudianteAsignaturaRepositoryJPA;

    @Override
    public EstudianteAsignatura addEstudianteAsignatura(EstudianteAsignatura estudianteAsignatura) {
        return estudianteAsignaturaRepositoryJPA.save(estudianteAsignatura);
    }

    @Override
    public List<EstudianteAsignatura> getAsignaturasByEstudianteID(String id_estudiante) {
        return estudianteAsignaturaRepositoryJPA.getAsignaturasByEstudianteID(id_estudiante);
    }

    @Override
    public void addEstudianteAsignaturaByListOfIDS(List<EstudianteAsignatura> asignaturasList) {
        estudianteAsignaturaRepositoryJPA.saveAll(asignaturasList);
    }

    @Override
    public void deleteEstudianteAsignaturaByListOfIDS(List<EstudianteAsignatura> asignaturasList) {
        estudianteAsignaturaRepositoryJPA.deleteAll(asignaturasList);
    }

    @Override
    public List<EstudianteAsignatura> getEstudianteAsignaturaByAsignaturaID(String asignaturaID, String estudianteID) {
        return estudianteAsignaturaRepositoryJPA.getEstudianteAsignaturaByAsignaturaID(asignaturaID, estudianteID);
    }
}
