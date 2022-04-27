package com.cuetodev.ej3_1.Asignatura.infrastructure.controller.dto.input;

import com.cuetodev.ej3_1.Asignatura.domain.Asignatura;
import com.cuetodev.ej3_1.Estudiante_Asignatura.domain.EstudianteAsignatura;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AsignaturaInputDTO {
    private String id_asignatura;
    private String nombre;
    private String comments;
    private Set<EstudianteAsignatura> estudiantes;

    public Asignatura convertDTOEntity() {
        return new Asignatura(id_asignatura, nombre, comments, estudiantes);
    }
}
