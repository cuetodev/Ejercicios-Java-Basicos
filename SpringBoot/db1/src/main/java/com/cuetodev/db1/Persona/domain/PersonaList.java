package com.cuetodev.db1.Persona.domain;

import com.cuetodev.db1.Persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaList {
    List<PersonaOutputDTO> peopleList;
    int totalElements;

    public PersonaList(List<PersonaOutputDTO> peopleList) {
        this.peopleList = peopleList;
        totalElements = peopleList.size();
    }
}
