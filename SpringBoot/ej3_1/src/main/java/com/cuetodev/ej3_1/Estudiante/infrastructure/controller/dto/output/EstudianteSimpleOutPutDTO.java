package com.cuetodev.ej3_1.Estudiante.infrastructure.controller.dto.output;

import com.cuetodev.ej3_1.Estudiante.domain.Estudiante;
import com.cuetodev.ej3_1.Estudiante_Asignatura.domain.EstudianteAsignatura;
import com.cuetodev.ej3_1.Persona.domain.Persona;
import com.cuetodev.ej3_1.Profesor.domain.Profesor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
public class EstudianteSimpleOutPutDTO {
    private String id_estudiante;
    private String comments;
    private Integer num_hours_week;
    private String branch;

    public EstudianteSimpleOutPutDTO(Estudiante estudiante) {
        if (estudiante == null) return;
        setId_estudiante(estudiante.getId_estudiante());
        setComments(estudiante.getComments());
        setNum_hours_week(estudiante.getNum_hours_week());
        setBranch(estudiante.getBranch());
    }
}
