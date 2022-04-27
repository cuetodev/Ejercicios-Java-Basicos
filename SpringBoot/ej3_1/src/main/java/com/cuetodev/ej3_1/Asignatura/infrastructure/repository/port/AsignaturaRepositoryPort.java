package com.cuetodev.ej3_1.Asignatura.infrastructure.repository.port;

import com.cuetodev.ej3_1.Asignatura.domain.Asignatura;

import java.util.Optional;

public interface AsignaturaRepositoryPort {
    public Asignatura addAsignatura(Asignatura asignatura);
    public Optional<Asignatura> findById(String id_asignatura);
}
