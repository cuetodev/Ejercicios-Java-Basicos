package com.cuetodev.db1.Persona.infrastructure.repository.port;

import com.cuetodev.db1.Persona.domain.Persona;
import com.cuetodev.db1.Persona.infrastructure.controller.dto.output.PersonaOutputDTO;

import java.util.List;

public interface PersonaRepositoryPort {
    public Persona save(Persona persona);
    public Persona findPersonaById(int id) throws Exception;
    public List<Persona> findPersonaByUsuario(String usuario) throws Exception;
    public List<Persona> getAllPeople() throws Exception;
    public int deletePerson(int id) throws Exception;
    public Persona updatePerson(Persona personaActualizada) throws Exception;
}
