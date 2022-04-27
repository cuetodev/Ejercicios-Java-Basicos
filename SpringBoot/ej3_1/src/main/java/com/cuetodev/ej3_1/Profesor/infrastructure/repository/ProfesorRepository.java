package com.cuetodev.ej3_1.Profesor.infrastructure.repository;

import com.cuetodev.ej3_1.Profesor.domain.Profesor;
import com.cuetodev.ej3_1.Profesor.infrastructure.repository.jpa.ProfesorRepositoryJPA;
import com.cuetodev.ej3_1.Profesor.infrastructure.repository.port.ProfesorRepositoryPort;
import com.cuetodev.ej3_1.ErrorHandling.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfesorRepository implements ProfesorRepositoryPort {

    @Autowired
    private ProfesorRepositoryJPA profesorRepositoryJPA;

    @Override
    public Profesor save(Profesor profesor) {
        if (profesor == null) return new Profesor();
        profesorRepositoryJPA.save(profesor);
        return profesor;
    }

    public Profesor findProfesorById(String id) throws NotFoundException {
        return profesorRepositoryJPA.findById(id).orElseThrow(() -> new NotFoundException("Id no encontrada"));
    }

    @Override
    public Optional<Profesor> findProfesorByPersonID(Integer id_persona) {
        return profesorRepositoryJPA.findProfesorByPersonaID(id_persona);
    }
}
