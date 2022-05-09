package com.cuetodev.ej3_1.Persona.infrastructure.controller.dto.input;

import com.cuetodev.ej3_1.Persona.domain.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonaInputDTO {
    private Integer id;
    private String usuario;
    private String password;
    private String name;
    private String surname;
    private String company_email;
    private String persona_email;
    private String city;
    private Boolean active;
    private Date created_date;
    private String imagen_url;
    private Date termination_date;
    private Boolean admin;

    public Persona convertInputDtoToEntity() {
        return new Persona(id, usuario, password, name, surname, company_email, persona_email, city, active, created_date, imagen_url, termination_date, admin);
    }
}
