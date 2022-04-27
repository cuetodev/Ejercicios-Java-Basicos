package com.cuetodev.ej3_1.Profesor.infrastructure.controller.dto.input;

import com.cuetodev.ej3_1.Profesor.domain.Profesor;
import lombok.Data;

@Data
public class ProfesorInputDTO {
    private String id_profesor;
    private String id_persona;
    private String comments;
    private String branch;

    public Profesor convertInputDTOEntity() {
        return new Profesor(id_profesor, null, comments, branch);
    }
}
