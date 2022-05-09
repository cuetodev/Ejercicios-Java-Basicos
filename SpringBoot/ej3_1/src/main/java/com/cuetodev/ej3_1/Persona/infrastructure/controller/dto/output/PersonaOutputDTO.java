package com.cuetodev.ej3_1.Persona.infrastructure.controller.dto.output;

import com.cuetodev.ej3_1.Persona.domain.Persona;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@NoArgsConstructor
public class PersonaOutputDTO {
    private int id;
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

    public void setCreated_date(String date) throws ParseException {
        try {
            this.created_date = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException p) {
            this.created_date = new Date();
        }
    }

    // Hago la transformación de la entidad a mi output que al final son setters y getters
    public PersonaOutputDTO(Persona persona) throws ParseException {
        if (persona == null) return;
        setId(persona.getId());
        setUsuario(persona.getUsuario());
        setPassword(persona.getPassword());
        setName(persona.getName());
        setSurname(persona.getSurname());
        setCompany_email(persona.getCompany_email());
        setPersona_email(persona.getPersona_email());
        setCity(persona.getCity());
        setActive(persona.getActive());
        setCreated_date(persona.getCreated_date());
        setImagen_url(persona.getImagen_url());
        setTermination_date(persona.getTermination_date());
        setAdmin(persona.getAdmin());
    }
}
