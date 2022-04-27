package com.cuetodev.ej3_1.Asignatura.infrastructure.controller.dto.output;

import com.cuetodev.ej3_1.Asignatura.domain.Asignatura;
import com.cuetodev.ej3_1.Estudiante_Asignatura.domain.EstudianteAsignatura;
import lombok.Data;

import java.util.Set;

@Data
public class AsignaturaOutputDTO {
    private String id_asignatura;
    private String nombre;
    private String comments;
    private Set<EstudianteAsignatura> estudiantes;

    public AsignaturaOutputDTO(Asignatura asignatura) {
        setId_asignatura(asignatura.getId_asignatura());
        setNombre(asignatura.getNombre());
        setComments(asignatura.getComments());
        setEstudiantes(asignatura.getEstudiantes());
    }
}
