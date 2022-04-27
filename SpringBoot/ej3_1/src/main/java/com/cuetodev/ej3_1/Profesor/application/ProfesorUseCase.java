package com.cuetodev.ej3_1.Profesor.application;

import com.cuetodev.ej3_1.Profesor.application.port.ProfesorPort;
import com.cuetodev.ej3_1.Profesor.domain.Profesor;
import com.cuetodev.ej3_1.Profesor.infrastructure.repository.port.ProfesorRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfesorUseCase implements ProfesorPort {
    @Autowired
    private ProfesorRepositoryPort profesorRepositoryPort;

    @Override
    public Profesor insertProfesor(Profesor profesor) {
        // Llamo al save del repository
        profesorRepositoryPort.save(profesor);
        return profesor;
    }

    @Override
    public Profesor findProfesorById(String id) throws Exception {
        return profesorRepositoryPort.findProfesorById(id);
    }

    @Override
    public Optional<Profesor> findProfesorByPersonID(Integer id_persona) {
        return profesorRepositoryPort.findProfesorByPersonID(id_persona);
    }
}
