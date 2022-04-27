package com.cuetodev.ej3_1.Profesor.infrastructure.controller.dto.output;

import com.cuetodev.ej3_1.Persona.domain.Persona;
import com.cuetodev.ej3_1.Profesor.domain.Profesor;
import lombok.Data;

@Data
public class ProfesorOutputDTO {
    private String id_profesor;
    private Persona persona;
    private String comments;
    private String branch;

    public ProfesorOutputDTO(Profesor profesor) {
        setId_profesor(profesor.getId_profesor());
        setPersona(profesor.getPersona());
        setComments(profesor.getComments());
        setBranch(profesor.getBranch());
    }
}
