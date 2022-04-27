package com.cuetodev.ej3_1.Asignatura.application.port;

import com.cuetodev.ej3_1.Asignatura.domain.Asignatura;


public interface AsignaturaPort {
    public Asignatura addAsignatura(Asignatura asignatura);
    public Asignatura findById(String id_asignatura);
}
