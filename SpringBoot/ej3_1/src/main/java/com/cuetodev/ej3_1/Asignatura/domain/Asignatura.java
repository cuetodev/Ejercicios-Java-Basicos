package com.cuetodev.ej3_1.Asignatura.domain;

import com.cuetodev.ej3_1.Estudiante_Asignatura.domain.EstudianteAsignatura;
import com.cuetodev.ej3_1.SharedSquences.StringPrefixedSequenceIdGenerator;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Asignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "asignatura_seq")
    @GenericGenerator(
            name = "asignatura_seq",
            strategy = "com.cuetodev.ej3_1.SharedSquences.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "AS"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%08d")
            }
    )
    private String id_asignatura;

    private String nombre;

    private String comments;

    @OneToMany(mappedBy = "asignatura", cascade = CascadeType.DETACH)
    @JsonManagedReference
    Set<EstudianteAsignatura> estudiantes;
}
