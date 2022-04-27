package com.cuetodev.ej3_1.Profesor.domain;

import com.cuetodev.ej3_1.Persona.domain.Persona;
import com.cuetodev.ej3_1.SharedSquences.StringPrefixedSequenceIdGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profesor_seq")
    @GenericGenerator(
        name = "profesor_seq",
        strategy = "com.cuetodev.ej3_1.SharedSquences.StringPrefixedSequenceIdGenerator",
        parameters = {
            @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
            @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "PRO"),
            @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%08d")
        }
    )
    private String id_profesor;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Persona persona;

    private String comments;

    @NotNull
    private String branch;

}
