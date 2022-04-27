package com.cuetodev.ej3_1.Estudiante.infrastructure.controller.dto.input;

import com.cuetodev.ej3_1.Estudiante_Asignatura.domain.EstudianteAsignatura;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstudianteInputDTO {
    private String id_estudiante;
    private int persona;
    private String id_profesor;
    private String comments;
    private Integer num_hours_week;
    private String branch;
    private Set<EstudianteAsignatura> asignaturas;
}
