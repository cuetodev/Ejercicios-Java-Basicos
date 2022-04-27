package com.cuetodev.ej3_1.Estudiante_Asignatura.domain;
import com.cuetodev.ej3_1.Asignatura.domain.Asignatura;
import com.cuetodev.ej3_1.Estudiante.domain.Estudiante;
import com.cuetodev.ej3_1.SharedSquences.StringPrefixedSequenceIdGenerator;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteAsignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estudiante_asignatura_seq")
    @GenericGenerator(
            name = "estudiante_asignatura_seq",
            strategy = "com.cuetodev.ej3_1.SharedSquences.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "ES_AS"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%08d")
            }
    )
    private String id;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_estudiante")
    @JsonBackReference(value = "asignaturas_estudiantes")
    private Estudiante estudiante;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_asignatura")
    @JsonBackReference
    private Asignatura asignatura;

    @NotNull
    // Fecha donde el estudiante empezó a estudiar la asignatura
    private Date initial_date;

    // Fecha donde el estudiante termina de estudiar la asignatura
    private Date finish_date;
}
