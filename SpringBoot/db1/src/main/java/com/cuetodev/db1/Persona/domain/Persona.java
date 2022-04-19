package com.cuetodev.db1.Persona.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    // El @Size lo puedo utilizar gracias a la libreria de java bean validation (mirar dependencias)
    @Size(min = 6, max = 10)
    @NotNull
    private String usuario;

    @NotNull
    private String password;

    @NotNull
    private String name;

    private String surname;

    @NotNull
    private String company_email;

    @NotNull
    private String persona_email;

    @NotNull
    private String city;

    @NotNull
    private Boolean active;

    @NotNull
    private Date created_date;

    private String imagen_url;

    private Date termination_date;

    public void setCreated_date(String date) throws ParseException {
        this.created_date = new SimpleDateFormat("yyyy-MM-dd").parse(date);
    }

    public String getCreated_date() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(this.created_date);
    }

    public Persona(String id, String usuario, String password, String name,
    String surname,
    String company_email,
    String persona_email,
    String city,
    Boolean active,
    Date created_date,
    String imagen_url,
    Date termination_date) {
        this.id = Integer.parseInt(id);
        this.usuario = usuario;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.company_email = company_email;
        this.persona_email = persona_email;
        this.city = city;
        this.active = active;
        this.created_date = created_date;
        this.imagen_url = imagen_url;
        this.termination_date = termination_date;
    }
}
