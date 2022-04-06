package model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Persona {
    private String nombre;
    private String poblacion;
    private Integer edad;
}
