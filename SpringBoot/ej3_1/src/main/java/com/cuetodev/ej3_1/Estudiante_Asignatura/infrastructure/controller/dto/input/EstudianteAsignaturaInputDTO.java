package com.cuetodev.ej3_1.Estudiante_Asignatura.infrastructure.controller.dto.input;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class EstudianteAsignaturaInputDTO {
    private String id;
    private String id_estudiante;
    private String id_asignatura;
    private Date initial_date;
    private Date finish_date;
}
