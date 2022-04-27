package com.cuetodev.ej3_1.Estudiante.infrastructure.repository;

import com.cuetodev.ej3_1.Estudiante.domain.Estudiante;
import com.cuetodev.ej3_1.Estudiante.infrastructure.repository.jpa.EstudianteRepositoryJPA;
import com.cuetodev.ej3_1.Estudiante.infrastructure.repository.port.EstudianteRepositoryPort;
import com.cuetodev.ej3_1.errorhandling.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EstudianteRepository implements EstudianteRepositoryPort {

    @Autowired
    private EstudianteRepositoryJPA estudianteRepositoryJPA;

    @Override
    public Estudiante save(Estudiante estudiante) {
        if (estudiante == null) return new Estudiante();
        estudianteRepositoryJPA.save(estudiante);
        return estudiante;
    }

    @Override
    public Optional<Estudiante> findEstudianteByPersonaID(Integer id_persona) {
        return estudianteRepositoryJPA.findEstudianteByPersonaID(id_persona);
    }

    public Estudiante findEstudianteById(String id) throws NotFoundException {
        return estudianteRepositoryJPA.findById(id).orElseThrow(() -> new NotFoundException("Id no encontrada"));
    }
}
