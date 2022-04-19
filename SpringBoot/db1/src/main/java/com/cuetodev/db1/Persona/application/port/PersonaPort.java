package com.cuetodev.db1.Persona.application.port;

import com.cuetodev.db1.Persona.domain.Persona;
import com.cuetodev.db1.Persona.infrastructure.controller.dto.input.PersonaInputDTO;
import com.cuetodev.db1.Persona.infrastructure.controller.dto.output.PersonaOutputDTO;

import java.text.ParseException;
import java.util.List;

public interface PersonaPort {
    public Persona insertPerson(Persona persona);
    public Persona findPersonaById(int id) throws Exception;
    public List<Persona> findPersonaByUsuario(String usuario) throws Exception;
    public List<Persona> getAllPeople() throws Exception;
    public int deletePerson(int id) throws Exception;
    public Persona updatePerson(Persona personaOriginal, PersonaInputDTO personaRecibida) throws Exception;
}
