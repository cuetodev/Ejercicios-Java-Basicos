package com.cuetodev.ej3_1.Asignatura.infrastructure.repository.jpa;

import com.cuetodev.ej3_1.Asignatura.domain.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsignaturaRepositoryJPA extends JpaRepository<Asignatura, String> {

}
