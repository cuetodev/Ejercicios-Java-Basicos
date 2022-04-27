package com.cuetodev.ej3_1.Estudiante.infrastructure.controller.dto.output;

import com.cuetodev.ej3_1.Estudiante.domain.Estudiante;
import com.cuetodev.ej3_1.Persona.domain.Persona;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@NoArgsConstructor
public class EstudianteFullOutPutDTO {
    private String id_estudiante;
    private Persona persona;
    private String comments;
    private Integer num_hours_week;
    private String branch;

    public EstudianteFullOutPutDTO(Estudiante estudiante) {
        if (estudiante == null) return;
        setId_estudiante(estudiante.getId_estudiante());
        setPersona(estudiante.getPersona());
        setComments(estudiante.getComments());
        setNum_hours_week(estudiante.getNum_hours_week());
        setBranch(estudiante.getBranch());
    }
}
