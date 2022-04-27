package com.cuetodev.ej3_1.Estudiante.domain;

import com.cuetodev.ej3_1.Estudiante_Asignatura.domain.EstudianteAsignatura;
import com.cuetodev.ej3_1.Persona.domain.Persona;
import com.cuetodev.ej3_1.Profesor.domain.Profesor;
import com.cuetodev.ej3_1.SharedSquences.StringPrefixedSequenceIdGenerator;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estudiante_seq")
    @GenericGenerator(
            name = "estudiante_seq",
            strategy = "com.cuetodev.ej3_1.SharedSquences.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "ES"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%08d")
            }
    )
    private String id_estudiante;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    @JsonBackReference
    @NotNull
    private Persona persona;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_profesor")
    private Profesor profesor;

    private String comments;

    @NotNull
    private Integer num_hours_week;

    @NotNull
    private String branch;

    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.DETACH)
    @JsonManagedReference(value = "asignaturas_estudiantes")
    private Set<EstudianteAsignatura> asignaturas;
}
