package com.cuetodev.ej3_1.Profesor.infrastructure.repository.port;

import com.cuetodev.ej3_1.Profesor.domain.Profesor;

import java.util.Optional;

public interface ProfesorRepositoryPort {
    public Profesor save(Profesor profesor);
    public Profesor findProfesorById(String id) throws Exception;
    public Optional<Profesor> findProfesorByPersonID(Integer id_persona);
}
