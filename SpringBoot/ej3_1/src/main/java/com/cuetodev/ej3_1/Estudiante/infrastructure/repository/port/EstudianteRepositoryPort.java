package com.cuetodev.ej3_1.Estudiante.infrastructure.repository.port;

import com.cuetodev.ej3_1.Estudiante.domain.Estudiante;

import java.util.Optional;

public interface EstudianteRepositoryPort {
    public Estudiante save(Estudiante estudiante);
    public Estudiante findEstudianteById(String id) throws Exception;
    public Optional<Estudiante> findEstudianteByPersonaID(Integer id_persona);
}
