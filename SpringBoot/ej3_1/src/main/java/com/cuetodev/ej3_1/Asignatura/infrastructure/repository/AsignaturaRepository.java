package com.cuetodev.ej3_1.Asignatura.infrastructure.repository;

import com.cuetodev.ej3_1.Asignatura.domain.Asignatura;
import com.cuetodev.ej3_1.Asignatura.infrastructure.repository.jpa.AsignaturaRepositoryJPA;
import com.cuetodev.ej3_1.Asignatura.infrastructure.repository.port.AsignaturaRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AsignaturaRepository implements AsignaturaRepositoryPort {

    @Autowired
    AsignaturaRepositoryJPA asignaturaRepositoryJPA;

    @Override
    public Asignatura addAsignatura(Asignatura asignatura) {
        return asignaturaRepositoryJPA.save(asignatura);
    }

    @Override
    public Optional<Asignatura> findById(String id_asignatura) {
        return asignaturaRepositoryJPA.findById(id_asignatura);
    }
}
