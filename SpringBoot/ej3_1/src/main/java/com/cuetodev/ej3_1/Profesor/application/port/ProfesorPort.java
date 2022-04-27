package com.cuetodev.ej3_1.Profesor.application.port;

import com.cuetodev.ej3_1.Profesor.domain.Profesor;

import java.util.Optional;

public interface ProfesorPort {
    public Profesor insertProfesor(Profesor profesor);
    public Profesor findProfesorById(String id_profesor) throws Exception;
    public Optional<Profesor> findProfesorByPersonID(Integer id_persona);
}
