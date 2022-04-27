package com.cuetodev.ej3_1.Asignatura.application;

import com.cuetodev.ej3_1.Asignatura.application.port.AsignaturaPort;
import com.cuetodev.ej3_1.Asignatura.domain.Asignatura;
import com.cuetodev.ej3_1.Asignatura.infrastructure.repository.port.AsignaturaRepositoryPort;
import com.cuetodev.ej3_1.ErrorHandling.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AsignaturaUseCase implements AsignaturaPort {
    @Autowired private AsignaturaRepositoryPort asignaturaRepositoryPort;

    @Override
    public Asignatura addAsignatura(Asignatura asignatura) {
        return asignaturaRepositoryPort.addAsignatura(asignatura);
    }

    @Override
    public Asignatura findById(String id_asignatura) {
        Optional<Asignatura> asignaturaOptional = asignaturaRepositoryPort.findById(id_asignatura);

        if (asignaturaOptional.isEmpty()) throw new NotFoundException("La asignatura con ID: " + id_asignatura + ", no ha sido encontrada.");
        return asignaturaOptional.get();
    }
}
